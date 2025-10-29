package com.example.learnit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.learnit.home.component.HomeTopBar
import com.example.learnit.home.component.TopMenu
import com.example.learnit.profile.NavGraph
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
