package com.example.learnit.task

import com.example.learnit.task.model.TaskItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class TaskRepository(
    private val db: FirebaseFirestore = FirebaseFirestore.getInstance(),
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()
) {

    private fun tasksCollection() =
        db.collection("users")
            .document(auth.currentUser?.uid ?: throw IllegalStateException("No user"))
            .collection("tasks")

    // add
    suspend fun addTask(item: TaskItem) {
        val data = mapOf(
            "title" to item.title,
            "notes" to item.notes,
            "deadline" to item.deadline
        )
        tasksCollection().add(data).await()
    }

    // update
    suspend fun updateTask(item: TaskItem) {
        tasksCollection().document(item.id).update(
            mapOf(
                "title" to item.title,
                "notes" to item.notes,
                "deadline" to item.deadline
            )
        ).await()
    }

    // delete
    suspend fun deleteTask(id: String) {
        tasksCollection().document(id).delete().await()
    }
}
