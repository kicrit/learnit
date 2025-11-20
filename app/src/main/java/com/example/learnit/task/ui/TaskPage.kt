package com.example.learnit.task.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.SnackbarHost
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.learnit.task.TaskViewModel
import com.example.learnit.task.component.TopTaskBar
import com.example.learnit.task.model.TaskItem
import kotlinx.coroutines.launch

@Composable
fun TaskPage(modifier: Modifier,
    navController: NavController,
    viewModel: TaskViewModel = viewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }

    val tasks by viewModel.tasks.observeAsState(emptyList())
    val loading by viewModel.loading.observeAsState(false)
    val error by viewModel.error.observeAsState()

    val coroutineScope = rememberCoroutineScope()

    var showAddDialog by remember { mutableStateOf(false) }
    var editingTask by remember { mutableStateOf<TaskItem?>(null) }

    LaunchedEffect(error) {
        error?.let {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(it)
            }
            viewModel.clearError()
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopTaskBar(
            title = "Task List",
            onBackClick = { navController.popBackStack() },
            onAddClick = { showAddDialog = true }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp)) {
            if (tasks.isEmpty()) {
                Text(text = "Belum ada tugas", color = Color.Gray, modifier = Modifier.padding(8.dp))
            } else {
                TaskList(
                    tasks = tasks,
                    onEdit = { task ->
                        editingTask = task
                        showAddDialog = true
                    },
                    onDelete = { task ->
                        viewModel.deleteTask(task.id) { success, err ->
                            if (!success && err != null) {
                                coroutineScope.launch { snackbarHostState.showSnackbar(err) }
                            }
                        }
                    }
                )
            }

            // snackbar
            SnackbarHost(hostState = snackbarHostState, modifier = Modifier.align(Alignment.BottomCenter))
        }
    }

    if (showAddDialog) {
        AddEditTaskDialog(
            initial = editingTask,
            onDismiss = {
                showAddDialog = false
                editingTask = null
            },
            onSave = { title, notes, deadline ->
                if (editingTask == null) {
                    viewModel.addTask(title, notes, deadline) { success, err ->
                        if (!success && err != null) coroutineScope.launch { snackbarHostState.showSnackbar(err) }
                    }
                } else {
                    val updated = editingTask!!.copy(title = title, notes = notes, deadline = deadline)
                    viewModel.updateTask(updated) { success, err ->
                        if (!success && err != null) coroutineScope.launch { snackbarHostState.showSnackbar(err) }
                    }
                }
                showAddDialog = false
                editingTask = null
            }
        )
    }
}
