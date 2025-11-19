/*package com.example.learnit.task.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.model
import com.example.learnit.task.TopTaskBar
import com.example.learnit.task.component.TaskList

@Composable
fun TaskPage(
    tasks: List<Task>,
    onAddClick: () -> Unit,
    onDeleteClick: (Task) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
            .padding(16.dp)
    ) {
        // Bagian top bar
        TopTaskBar(
            onAddClick = onAddClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Bagian list task
        TaskList(
            tasks = tasks,
            onDeleteClick = onDeleteClick
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TaskPagePreview() {
    // Data dummy buat preview
    val sampleTasks = listOf(
        Task(id = 1, title = "Belajar Jetpack Compose", description = "Bikin UI keren pake Compose"),
        Task(id = 2, title = "Ngoding CRUD Room", description = "Bikin database lokal untuk task"),
        Task(id = 3, title = "Review UI", description = "Cek layout biar responsive")
    )

    MaterialTheme {
        TaskPage(
            tasks = sampleTasks,
            onAddClick = { /* TODO */ },
            onDeleteClick = { /* TODO */ }
        )
    }
}
*/