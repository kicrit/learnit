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
import com.example.learnit.home.HomeScreen
import com.example.learnit.login.ProfileSection
import com.example.learnit.login.RegisterSection
import com.example.learnit.profile.EditProfileScreen
import com.example.learnit.profile.ProfileScreen
import com.example.learnit.splash.SplashScreen



/*
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "splash" // tampil pertama kali = ProfileSection
    ) {

        composable("splash") {
            SplashScreen(navController = navController)
        }

        // 🔹 Halaman Login
        composable("login") {
            ProfileSection(
                onNavigateToRegister = {
                    navController.navigate("register") // pindah ke register
                },
                onNavigateToHomeScreen = {
                    navController.navigate("HomeScreen")
                }
            )
        }

        // 🔹 Halaman Register
        composable("register") {
            RegisterSection(
                onNavigateToLogin = {
                    navController.navigate("login") // kembali ke login
                },
                onNavigateToProfile = {
                    navController.navigate("profile")
                }
            )
        }



        // 🔹 Halaman Profile (kalau nanti mau lanjut setelah login)
        composable("HomeScreen") {
            HomeScreen(navController)
        }

        composable("Profile") {
            ProfileScreen(navController)
        }
        // 🔹 Halaman Edit Profile (opsional)
        composable("editProfile") {
            EditProfileScreen(navController)
        }
    }
}
*/

@Composable
fun NavGraph(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login", builder = {
        composable("login") {
            ProfileSection(modifier, navController,authViewModel )
        }
        composable("register") {
            RegisterSection(modifier, navController,authViewModel )
        }

    })
}
