package com.example.learnit.task

import androidx.lifecycle.*
import com.example.learnit.task.model.TaskItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.launch

class TaskViewModel(
    private val repo: TaskRepository = TaskRepository(),
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) : ViewModel() {

    private val _tasks = MutableLiveData<List<TaskItem>>(emptyList())
    val tasks: LiveData<List<TaskItem>> = _tasks

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    private val _error = MutableLiveData<String?>(null)
    val error: LiveData<String?> = _error

    private var listenerRegistration: com.google.firebase.firestore.ListenerRegistration? = null

    init {
        startListening()
    }

    private fun tasksCollectionRef() =
        db.collection("users")
            .document(auth.currentUser?.uid ?: "")
            .collection("tasks")

    private fun startListening() {
        val uid = auth.currentUser?.uid ?: return
        listenerRegistration = tasksCollectionRef()
            .addSnapshotListener { snapshot, exc ->
                if (exc != null) {
                    _error.value = exc.localizedMessage
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    val list = snapshot.documents.map { doc ->
                        TaskItem(
                            id = doc.id,
                            title = doc.getString("title") ?: "",
                            notes = doc.getString("notes") ?: "",
                            deadline = doc.getString("deadline") ?: ""
                        )
                    }
                    _tasks.value = list
                }
            }
    }

    override fun onCleared() {
        super.onCleared()
        listenerRegistration?.remove()
    }

    fun addTask(title: String, notes: String, deadline: String, onResult: (Boolean, String?) -> Unit = { _, _ -> }) {
        viewModelScope.launch {
            _loading.value = true
            try {
                repo.addTask(TaskItem(title = title, notes = notes, deadline = deadline))
                onResult(true, null)
            } catch (e: Exception) {
                _error.value = e.localizedMessage
                onResult(false, e.localizedMessage)
            } finally {
                _loading.value = false
            }
        }
    }

    fun updateTask(item: TaskItem, onResult: (Boolean, String?) -> Unit = { _, _ -> }) {
        viewModelScope.launch {
            _loading.value = true
            try {
                repo.updateTask(item)
                onResult(true, null)
            } catch (e: Exception) {
                _error.value = e.localizedMessage
                onResult(false, e.localizedMessage)
            } finally {
                _loading.value = false
            }
        }
    }

    fun deleteTask(id: String, onResult: (Boolean, String?) -> Unit = { _, _ -> }) {
        viewModelScope.launch {
            _loading.value = true
            try {
                repo.deleteTask(id)
                onResult(true, null)
            } catch (e: Exception) {
                _error.value = e.localizedMessage
                onResult(false, e.localizedMessage)
            } finally {
                _loading.value = false
            }
        }
    }

    fun clearError() {
        _error.value = null
    }
}
