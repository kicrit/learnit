package com.example.learnit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.auth.UserViewModel
import com.example.learnit.task.TaskViewModel
import com.example.learnit.ui.theme.LearnitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val authViewModel: AuthViewModel by viewModels()
        val userViewModel: UserViewModel by viewModels ()
        val taskViewModel: TaskViewModel by viewModels ()
        setContent {
            LearnitTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPaddding ->
                    NavGraph(
                        modifier = Modifier.padding(innerPaddding),
                        authViewModel = authViewModel,
                        userViewModel = userViewModel,
                        taskViewModel = taskViewModel

                    )
                }
            }
        }
    }
}

/*@Composable
fun AppContent(navController: androidx.navigation.NavHostController) {
    NavGraph(navController = navController)
}
*/