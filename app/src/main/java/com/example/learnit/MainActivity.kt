package com.example.learnit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.learnit.ui.theme.LearnitTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnitTheme {
                val navController = rememberNavController()
                AppContent(navController)
            }
        }
    }
}

@Composable
fun AppContent(navController: androidx.navigation.NavHostController) {
    NavGraph(navController = navController)
}
