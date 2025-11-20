package com.example.learnit.task.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.AlertDialog
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.learnit.task.model.TaskItem

@Composable
fun AddEditTaskDialog(
    initial: TaskItem? = null,
    onDismiss: () -> Unit,
    onSave: (title: String, notes: String, deadline: String) -> Unit
) {
    var title by remember { mutableStateOf(initial?.title ?: "") }
    var notes by remember { mutableStateOf(initial?.notes ?: "") }
    var deadline by remember { mutableStateOf(initial?.deadline ?: "") }

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = if (initial == null) "Tambah Task" else "Edit Task") },
        text = {
            Column {
                OutlinedTextField(value = title, onValueChange = { title = it }, label = { Text("Judul") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = notes, onValueChange = { notes = it }, label = { Text("Catatan") }, modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(value = deadline, onValueChange = { deadline = it }, label = { Text("Deadline") }, modifier = Modifier.fillMaxWidth())
            }
        },
        confirmButton = {
            Button(onClick = {
                onSave(title.trim(), notes.trim(), deadline.trim())
            }) {
                Text("Simpan")
            }
        },
        dismissButton = {
            Button(onClick = onDismiss) {
                Text("Batal")
            }
        }
    )
}
