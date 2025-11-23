package com.example.learnit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.auth.UserViewModel
import com.example.learnit.course.coursedetail.WebProgramming
import com.example.learnit.course.course.CoursePage
import com.example.learnit.home.HomeScreen
import com.example.learnit.login.ProfileSection
import com.example.learnit.login.RegisterSection
import com.example.learnit.mycourse.MyCourseScreen
import com.example.learnit.profile.EditProfileScreen
import com.example.learnit.profile.ProfileScreen
import com.example.learnit.task.TaskViewModel
import com.example.learnit.task.ui.AddEditTaskScreen
import com.example.learnit.task.ui.TaskPage


@Composable
fun NavGraph(modifier: Modifier = Modifier, authViewModel: AuthViewModel,userViewModel: UserViewModel,taskViewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", modifier = modifier) {
        composable("login") {
            ProfileSection(navController = navController, authViewModel = authViewModel)
        }
        composable("register") {
            RegisterSection(navController = navController, authViewModel = authViewModel)
        }
        composable("home") {
            HomeScreen(navController = navController, authViewModel = authViewModel, userViewModel = userViewModel)
        }
        composable("profile") {
            ProfileScreen(navController = navController, authViewModel = authViewModel)
        }
        composable("course") {
            CoursePage(navController = navController)
        }
        composable("task") {
            TaskPage(navController = navController, viewModel = taskViewModel)
        }
        composable(
            route = "addtask?taskId={taskId}",
            arguments = listOf(navArgument("taskId") {
                type = NavType.StringType
                nullable = true
            })
        ) { backStackEntry ->
            AddEditTaskScreen(
                navController = navController,
                taskViewModel = taskViewModel,
                taskId = backStackEntry.arguments?.getString("taskId")
            )
        }
        composable("editprofile") {
            EditProfileScreen(navController = navController, authViewModel = authViewModel)
        }
        composable("webprogramming") {
            WebProgramming(navController = navController)
        }
        composable("mycourse") {
            MyCourseScreen(navController = navController, navBack = { navController.popBackStack() })
        }
    }
}