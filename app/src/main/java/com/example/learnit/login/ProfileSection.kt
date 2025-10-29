package com.example.learnit.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProfileSection(
    onNavigateToRegister: () -> Unit,
    onNavigateToProfile: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize() // ubah jadi fillMaxSize biar bisa ngatur jarak vertikal penuh
            .background(Color.White)
            .padding(horizontal = 24.dp, vertical = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween // kuncinya di sini
    ) {
        // Bagian atas
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Welcome to Learn.It!",
                fontSize = 18.sp,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 12.dp)
            )

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
                        onClick = { /* TODO: aksi tombol kiri */ },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00035D),
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
                        onClick = { onNavigateToRegister() },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
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

            var username by remember { mutableStateOf("") }

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

            var password by remember { mutableStateOf("") }

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
        }

        // Bagian bawah → tombol login
        Box(
            modifier = Modifier
                .padding(horizontal = 48.dp, vertical = 36.dp)
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
                onClick = { onNavigateToProfile() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Login",
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp
                )
            }
        }
    }
}
