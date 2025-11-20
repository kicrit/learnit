package com.example.learnit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.auth.UserViewModel
import com.example.learnit.course.mycourse.MyCoursePage
import com.example.learnit.home.HomeScreen
import com.example.learnit.login.ProfileSection
import com.example.learnit.login.RegisterSection
import com.example.learnit.profile.EditProfileScreen
import com.example.learnit.profile.ProfileScreen
import com.example.learnit.splash.SplashScreen
import com.example.learnit.task.TaskViewModel
import com.example.learnit.task.ui.TaskDetailScreen
import com.example.learnit.task.ui.TaskPage


@Composable
fun NavGraph(modifier: Modifier = Modifier, authViewModel: AuthViewModel,userViewModel: UserViewModel,taskViewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            ProfileSection(modifier, navController,authViewModel )
        }
        composable("register") {
            RegisterSection(modifier, navController,authViewModel )
        }
        composable("home") {
            HomeScreen(modifier, navController,authViewModel,userViewModel )
        }
        composable("profile") {
            ProfileScreen(modifier, navController,authViewModel)
        }
        composable("mycourse") {
            MyCoursePage(modifier,navController)
        }
        composable("task") {
            TaskPage(modifier,navController, taskViewModel)
        }
        composable("editprofile") {
            EditProfileScreen(modifier,navController)
        }




    })
}
