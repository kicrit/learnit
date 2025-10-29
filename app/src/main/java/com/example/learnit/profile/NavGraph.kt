package com.example.learnit.profile

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.learnit.login.ProfileSection
import com.example.learnit.login.RegisterSection

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "login" // tampil pertama kali = ProfileSection
    ) {
        // 🔹 Halaman Login
        composable("login") {
            ProfileSection(
                onNavigateToRegister = {
                    navController.navigate("register") // pindah ke register
                },
                onNavigateToProfile = {
                    navController.navigate("profile")
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
        composable("profile") {
            ProfileScreen(navController)
        }

        // 🔹 Halaman Edit Profile (opsional)
        composable("editProfile") {
            EditProfileScreen(navController)
        }
    }
}
