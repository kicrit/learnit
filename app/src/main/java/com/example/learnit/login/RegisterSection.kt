package com.example.learnit.login

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learnit.auth.AuthState
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun RegisterSection(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {

    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Authenticated -> navController.navigate("login")
            is AuthState.Error -> Toast.makeText(
                context, (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT
            ).show()
            else -> Unit
        }
    }

    // State input
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        // ─────────────────────────────────────────────
        // Bagian scroll
        // ─────────────────────────────────────────────
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 24.dp)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(48.dp))

            Text(
                text = "Welcome to Learn.It!",
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 12.dp)
            )

            // Top Tab: Login / Register
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(33.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFE60BFA),
                                Color(0xFF7C13FC),
                                Color(0xFF131BFF)
                            )
                        )
                    )
                    .height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp),
                    horizontalArrangement = Arrangement.spacedBy(40.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(
                        onClick = { navController.navigate("login") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .width(135.dp)
                            .height(50.dp)
                            .clip(RoundedCornerShape(33.dp))
                    ) {
                        Text("Login", fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = { /* Register tab aktif */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00035D),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .width(135.dp)
                            .height(50.dp)
                            .clip(RoundedCornerShape(33.dp))
                    ) {
                        Text("Register", fontWeight = FontWeight.Bold)
                    }
                }
            }

            Text(
                text = "Connect with expert mentors and accelerate your learning journey with personalized guidance.",
                fontSize = 14.sp,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(horizontal = 30.dp),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Username
            Text(
                text = "Username",
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Left
            )

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                placeholder = { Text("Enter your username") },
                singleLine = true,
                shape = RoundedCornerShape(40.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF131BFF),
                    unfocusedBorderColor = Color(0xFF131BFF),
                    cursorColor = Color(0xFF131BFF)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .height(65.dp)
            )

            // Email
            Text(
                text = "Email",
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Left
            )

            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = { Text("Enter your Email") },
                singleLine = true,
                shape = RoundedCornerShape(40.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF131BFF),
                    unfocusedBorderColor = Color(0xFF131BFF),
                    cursorColor = Color(0xFF131BFF)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .height(65.dp)
            )

            // Password
            Text(
                text = "Password",
                fontSize = 16.sp,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(horizontal = 16.dp),
                textAlign = TextAlign.Left
            )

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                placeholder = { Text("Enter your Password") },
                singleLine = true,
                shape = RoundedCornerShape(40.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedBorderColor = Color(0xFF131BFF),
                    unfocusedBorderColor = Color(0xFF131BFF),
                    cursorColor = Color(0xFF131BFF)
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 12.dp)
                    .height(65.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))
        }

        // ─────────────────────────────────────────────
        // Tombol Register BAWAH (selalu terlihat)
        // ─────────────────────────────────────────────
        Box(
            modifier = Modifier
                .padding(horizontal = 48.dp, vertical = 24.dp)
                .height(60.dp)
                .clip(RoundedCornerShape(36.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFE60BFA),
                            Color(0xFF7C13FC),
                            Color(0xFF131BFF)
                        )
                    )
                )
        ) {
            Button(
                onClick = {
                    authViewModel.signup(email,password,username)
                },
                enabled = authState.value != AuthState.Loading,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Register",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}

