package com.example.learnit

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.learnit.allcategories.model.AllCategoriesPage
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.auth.UserViewModel
import com.example.learnit.category.CategoryDetailScreen
import com.example.learnit.course.coursedetail.CourseDetailScreen
import com.example.learnit.course.course.CoursePage
import com.example.learnit.course.mycourse.MyCourseScreen
import com.example.learnit.course.videoplayer.VideoPlayerScreen
import com.example.learnit.home.HomeScreen
import com.example.learnit.login.ProfileSection
import com.example.learnit.login.RegisterSection
import com.example.learnit.profile.EditProfileScreen
import com.example.learnit.profile.ProfileScreen
import com.example.learnit.splash.SplashScreen
import com.example.learnit.task.TaskViewModel
import com.example.learnit.task.ui.TaskPage


@Composable
fun NavGraph(modifier: Modifier = Modifier, authViewModel: AuthViewModel,userViewModel: UserViewModel,taskViewModel: TaskViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash", builder = {

        composable("splash") {
            SplashScreen(navController = navController, authViewModel = authViewModel)
        }

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
        composable("course") {
            CoursePage(modifier,navController)
        }
        composable("task") {
            TaskPage(modifier,navController, taskViewModel)
        }
        composable("editprofile") {
            EditProfileScreen(modifier,navController, authViewModel)
        }
        composable(
            route = "course/{courseId}",
            arguments = listOf(navArgument("courseId") { type = NavType.IntType })
        ) {
            val courseId = it.arguments?.getInt("courseId") ?: 0
            CourseDetailScreen(navController = navController, courseId = courseId)
        }
        composable("mycourse") {
            MyCourseScreen(modifier,navController, navBack = { navController.popBackStack() })
        }
        composable("categories") {
            AllCategoriesPage(modifier,navController)
        }
        composable(
            route = "videoplayer/{videoId}",
            arguments = listOf(navArgument("videoId") { type = NavType.StringType })
        ) {
            val videoId = it.arguments?.getString("videoId") ?: ""
            VideoPlayerScreen(navController = navController, videoId = videoId)
        }
        composable(
            route = "category/{categoryName}",
            arguments = listOf(navArgument("categoryName") { type = NavType.StringType })
        ) {
            val categoryName = it.arguments?.getString("categoryName") ?: ""
            CategoryDetailScreen(navController = navController, category = categoryName)
        }

    })
}