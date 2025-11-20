package com.example.learnit.task.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learnit.task.model.TaskItem

@Composable
fun TaskDetailScreen(task: TaskItem, onBack: () -> Unit = {}) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(text = task.title, style = androidx.compose.material3.MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = task.notes)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Deadline: ${task.deadline}")
        Spacer(modifier = Modifier.height(16.dp))
        androidx.compose.material3.Button(onClick = onBack) {
            Text("Kembali")
        }
    }
}
