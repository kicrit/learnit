package com.example.learnit.task.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnit.ui.theme.LearnitTheme

data class TaskItem(
    val title: String,
    val notes: String,
    val deadline: String
)

@Composable
fun TaskList(
    tasks: List<TaskItem>
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9F9F9))
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(tasks) { task ->
            TaskCard(task)
        }
    }
}

@Composable
fun TaskCard(
    task: TaskItem,
    onEditClick: (TaskItem) -> Unit = {} // biar bisa di-handle di atas nanti
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // ===== Bagian kiri: isi task =====
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    text = task.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color(0xFF1A1A3F)
                )
                Text(
                    text = task.notes,
                    fontSize = 14.sp,
                    color = Color(0xFF606060)
                )
                Text(
                    text = "Deadline: ${task.deadline}",
                    fontSize = 12.sp,
                    color = Color(0xFF9E9E9E)
                )
            }

            // ===== Bagian kanan: tombol edit =====
            IconButton(onClick = { onEditClick(task) }) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = "Edit Task",
                    tint = Color(0xFF1A1A3F)
                )
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun TaskListPreview() {
    LearnitTheme {
        TaskList(
            tasks = listOf(
                TaskItem("Tugas Mobile", "Kerjain UI Compose", "30 Okt 2025"),
                TaskItem("Belajar Keamanan", "Review materi RSA", "2 Nov 2025"),
                TaskItem("Ngoding", "Selesaiin project IoT", "5 Nov 2025")
            )
        )
    }
}