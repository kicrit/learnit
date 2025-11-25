package com.example.learnit.task

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.learnit.task.model.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ListenerRegistration
import java.util.Date

class TaskViewModel(application: Application) : AndroidViewModel(application) {

    private val db: FirebaseFirestore = FirebaseFirestore.getInstance()
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    private val _tasks = MutableLiveData<List<Task>>(emptyList())
    val tasks: LiveData<List<Task>> = _tasks

    private val _selectedTask = MutableLiveData<Task?>()
    val selectedTask: LiveData<Task?> = _selectedTask

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    private var listenerRegistration: ListenerRegistration? = null
    private val scheduler = TaskAlarmScheduler(application)

    init {
        startListeningForTasks()
    }

    private fun getTasksCollection() = auth.currentUser?.uid?.let {
        db.collection("users").document(it).collection("tasks")
    }

    fun startListeningForTasks() {
        val collection = getTasksCollection() ?: run {
            _error.value = "User not logged in"
            return
        }

        listenerRegistration = collection.addSnapshotListener { snapshot, e ->
            if (e != null) {
                _error.value = e.localizedMessage
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val taskList = snapshot.documents.mapNotNull { doc ->
                    try {
                        // Defensive deserialization
                        doc.toObject(Task::class.java)?.copy(id = doc.id)
                    } catch (e: Exception) {
                        Log.e("TaskViewModel", "Error parsing task document ${doc.id}", e)
                        null // Ignore malformed data
                    }
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
        getTasksCollection()?.document(taskId)?.get()
            ?.addOnSuccessListener { document ->
                val task = document.toObject(Task::class.java)?.copy(id = document.id)
                _selectedTask.value = task
                _loading.value = false
            }
            ?.addOnFailureListener { e ->
                _error.value = e.localizedMessage
                _loading.value = false
            }
    }

    fun addTask(task: Task, onResult: (Boolean, String?) -> Unit) {
        _loading.value = true
        getTasksCollection()?.add(task)
            ?.addOnSuccessListener { documentReference ->
                val savedTask = task.copy(id = documentReference.id)
                scheduler.schedule(savedTask)
                onResult(true, null)
            }
            ?.addOnFailureListener { e -> onResult(false, e.localizedMessage) }
            ?.addOnCompleteListener { _loading.value = false }
    }

    fun updateTask(task: Task, onResult: (Boolean, String?) -> Unit) {
        _loading.value = true
        getTasksCollection()?.document(task.id)?.set(task)
            ?.addOnSuccessListener {
                scheduler.schedule(task) // Re-schedule with updated time
                onResult(true, null)
            }
            ?.addOnFailureListener { e -> onResult(false, e.localizedMessage) }
            ?.addOnCompleteListener { _loading.value = false }
    }

    fun deleteTask(task: Task, onResult: (Boolean, String?) -> Unit) {
        getTasksCollection()?.document(task.id)?.delete()
            ?.addOnSuccessListener {
                scheduler.cancel(task)
                onResult(true, null)
            }
            ?.addOnFailureListener { e -> onResult(false, e.localizedMessage) }
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
