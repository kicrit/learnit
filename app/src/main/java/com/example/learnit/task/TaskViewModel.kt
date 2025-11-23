package com.example.learnit.task

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.learnit.task.model.TaskItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration

class TaskViewModel(
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) : ViewModel() {

    private val _tasks = MutableLiveData<List<TaskItem>>(emptyList())
    val tasks: LiveData<List<TaskItem>> = _tasks

    private val _selectedTask = MutableLiveData<TaskItem?>()
    val selectedTask: LiveData<TaskItem?> = _selectedTask

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    private var listenerRegistration: ListenerRegistration? = null

    init {
        startListeningForTasks()
    }

    private fun getTasksCollection() = db.collection("users").document(auth.currentUser!!.uid).collection("tasks")

    private fun startListeningForTasks() {
        val user = auth.currentUser
        if (user == null) {
            _error.value = "User not logged in"
            return
        }

        listenerRegistration = getTasksCollection().addSnapshotListener { snapshot, e ->
            if (e != null) {
                _error.value = e.localizedMessage
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val taskList = snapshot.documents.mapNotNull { doc ->
                    doc.toObject(TaskItem::class.java)?.copy(id = doc.id)
                }
                _tasks.value = taskList
            }
        }
    }

    fun getTaskById(taskId: String) {
        if (taskId.isBlank()) {
            _selectedTask.value = null
            return
        }
        _loading.value = true
        getTasksCollection().document(taskId).get()
            .addOnSuccessListener { document ->
                val task = document.toObject(TaskItem::class.java)?.copy(id = document.id)
                _selectedTask.value = task
                _loading.value = false
            }
            .addOnFailureListener { e ->
                _error.value = e.localizedMessage
                _loading.value = false
            }
    }

    fun addTask(title: String, notes: String, deadline: String, onResult: (Boolean, String?) -> Unit) {
        _loading.value = true
        val task = TaskItem(title = title, notes = notes, deadline = deadline)
        getTasksCollection().add(task)
            .addOnSuccessListener { onResult(true, null) }
            .addOnFailureListener { e -> onResult(false, e.localizedMessage) }
            .addOnCompleteListener { _loading.value = false }
    }

    fun updateTask(id: String, title: String, notes: String, deadline: String, onResult: (Boolean, String?) -> Unit) {
        _loading.value = true
        val taskUpdates = mapOf(
            "title" to title,
            "notes" to notes,
            "deadline" to deadline
        )
        getTasksCollection().document(id).update(taskUpdates)
            .addOnSuccessListener { onResult(true, null) }
            .addOnFailureListener { e -> onResult(false, e.localizedMessage) }
            .addOnCompleteListener { _loading.value = false }
    }

    fun deleteTask(taskId: String, onResult: (Boolean, String?) -> Unit) {
        getTasksCollection().document(taskId).delete()
            .addOnSuccessListener { onResult(true, null) }
            .addOnFailureListener { e -> onResult(false, e.localizedMessage) }
    }

    fun clearSelectedTask() {
        _selectedTask.value = null
    }

    fun clearError() {
        _error.value = null
    }

    override fun onCleared() {
        super.onCleared()
        listenerRegistration?.remove()
    }
}
