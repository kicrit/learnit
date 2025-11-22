package com.example.learnit.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState // <-- IMPORT BARU
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnit.auth.AuthState // <-- IMPORT BARU
import com.example.learnit.auth.AuthViewModel // <-- IMPORT BARU
import com.example.learnit.ui.theme.Poppins
import kotlinx.coroutines.delay

@Composable
// 1. Tambahkan AuthViewModel sebagai parameter
fun SplashScreen(navController: NavController, authViewModel: AuthViewModel) {
    val infiniteTransition = rememberInfiniteTransition()
    val colorShift = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(4000, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        ), label = "colorShift"
    )

    val alpha = remember { Animatable(0f) }
    val scale = remember { Animatable(0.7f) }

    // 2. Amati status autentikasi dari ViewModel
    val authState by authViewModel.authState.observeAsState()

    // 3. Perbarui LaunchedEffect untuk bereaksi terhadap authState
    LaunchedEffect(key1 = authState) {
        // Jalankan animasi masuk tanpa memandang status login
        alpha.animateTo(1f, animationSpec = tween(1500))
        scale.animateTo(1f, animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy))

        // Beri jeda agar splash screen terlihat
        delay(1000)

        // Lakukan navigasi berdasarkan status autentikasi
        when (authState) {
            is AuthState.Authenticated -> {
                // Jika sudah login, pergi ke halaman home
                navController.navigate("home") {
                    popUpTo("splash") { inclusive = true }
                }
            }
            is AuthState.Unauthenticated, is AuthState.Error -> {
                // Jika belum login atau ada error, pergi ke halaman login
                navController.navigate("login") {
                    popUpTo("splash") { inclusive = true }
                }
            }
            AuthState.Loading, null -> {
                // Jika status masih loading, jangan lakukan apa-apa.
                // LaunchedEffect akan dipicu lagi saat statusnya berubah.
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        Color.Magenta.copy(alpha = 0.9f),
                        Color.Blue.copy(alpha = 0.8f)
                    ),
                    start = androidx.compose.ui.geometry.Offset(0f, colorShift.value),
                    end = androidx.compose.ui.geometry.Offset(colorShift.value, 0f)
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Learn.It",
            style = TextStyle(
                color = Color.White,
                fontSize = 48.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            ),
            modifier = Modifier
                .alpha(alpha.value)
                .scale(scale.value)
        )
    }
}

// Preview tidak perlu diubah, tapi akan selalu mengarah ke 'login' karena tidak ada AuthViewModel nyata
