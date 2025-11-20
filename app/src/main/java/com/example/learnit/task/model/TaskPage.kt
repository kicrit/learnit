package com.example.learnit.task.model

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.task.component.TaskItem
import com.example.learnit.task.component.TaskList
import com.example.learnit.task.component.TopTaskBar
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun TaskPage() {

    var tasks by remember {
        mutableStateOf(
            listOf(
                TaskItem("Tugas Mobile", "Kerjain UI Compose", "30 Okt 2025"),
                TaskItem("Belajar Keamanan", "Review materi RSA", "2 Nov 2025"),
                TaskItem("Ngoding", "Selesaikan project IoT", "5 Nov 2025")
            )
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopTaskBar(
            title = "Task List",
            onBackClick = { /* nanti dipasang navigation */ },
            onAddClick = {
                tasks = tasks + TaskItem(
                    "Tugas Baru",
                    "Isi detail tugas baru",
                    "10 Nov 2025"
                )
            }
        )

        Spacer(modifier = Modifier.height(8.dp))

        Column(modifier = Modifier.padding(horizontal = 16.dp)) {

            if (tasks.isEmpty()) {
                Text(
                    text = "Belum ada tugas",
                    color = Color.Gray,
                    modifier = Modifier.padding(8.dp)
                )
            } else {
                TaskList(tasks = tasks)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun TaskPagePreview() {
    LearnitTheme {
        TaskPage()
    }
}
