package com.example.learnit.task.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.learnit.component.BottomBar
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

    Scaffold(
        containerColor = Color(0xFFF8F9FD),
        bottomBar = {
            BottomBar(
                modifier = Modifier,
                navController = navController
            )
        }
    ) { paddingValues ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color(0xFFF8F9FD))
        ) {

            TopTaskBar(
                title = "My Tasks",
                onBackClick = { navController.popBackStack() },
                onAddClick = { navController.navigate("addtask") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp)
            ) {
                if (tasks.isEmpty()) {
                    Text(
                        text = "✨ No tasks yet, let's add one!",
                        color = Color.Gray,
                        modifier = Modifier.align(Alignment.Center)
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
                                    coroutineScope.launch {
                                        snackbarHostState.showSnackbar(err)
                                    }
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
}
