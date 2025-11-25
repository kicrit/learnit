package com.example.learnit.task.model

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class Task(
    var id: String = "",
    val title: String = "",
    val notes: String = "",
    @ServerTimestamp
    val dueDate: Date? = null,
    val dueTime: String = "", // Store time as a string e.g., "HH:mm"
    val isCompleted: Boolean = false
) {
    // No-argument constructor is required for Firestore deserialization
    constructor() : this("", "", "", null, "", false)
}
