package com.example.learnit.task.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.learnit.task.TaskViewModel
import com.example.learnit.task.component.TaskList
import com.example.learnit.task.component.TopTaskBar
import kotlinx.coroutines.launch

@Composable
fun TaskPage(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: TaskViewModel = viewModel()
) {
    val snackbarHostState = remember { SnackbarHostState() }

    val tasks by viewModel.tasks.observeAsState(emptyList())
    val error by viewModel.error.observeAsState()

    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(error) {
        error?.let {
            coroutineScope.launch {
                snackbarHostState.showSnackbar(it)
            }
            viewModel.clearError()
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopTaskBar(
            title = "Task List",
            onBackClick = { navController.popBackStack() },
            onAddClick = { navController.navigate("addtask") } // Ensure this matches NavGraph
        )
        Spacer(modifier = Modifier.height(8.dp))
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            if (tasks.isEmpty()) {
                Text(
                    text = "No tasks yet.",
                    color = Color.Gray,
                    modifier = Modifier.padding(16.dp).align(Alignment.Center)
                )
            } else {
                TaskList(
                    tasks = tasks,
                    onEdit = { task ->
                        navController.navigate("addtask?taskId=${task.id}")
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

            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.align(Alignment.BottomCenter)
            )
        }
    }
}
