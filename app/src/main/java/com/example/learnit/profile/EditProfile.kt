package com.example.learnit.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnit.R
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.auth.UpdateState

@Composable
fun EditProfileScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel
) {
    val userData by authViewModel.userData.observeAsState()
    val updateState by authViewModel.updateState.observeAsState()

    var username by remember { mutableStateOf("") }
    var selectedAvatarId by remember { mutableStateOf(1) }

    val avatars = listOf(R.drawable.avatar1, R.drawable.avatar3, R.drawable.avatar3)

    LaunchedEffect(userData) {
        userData?.let {
            username = it["username"] as? String ?: ""
            selectedAvatarId = (it["avatarId"] as? Long)?.toInt() ?: 1
        }
    }

    LaunchedEffect(updateState) {
        when (updateState) {
            is UpdateState.Success -> {
                navController.popBackStack()
                authViewModel.resetUpdateState()
            }
            is UpdateState.Error -> {
                // Optionally, show an error message to the user
            }
            else -> Unit
        }
    }

    val primaryColor = Color(0xFF2B1AFF)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Header
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.align(Alignment.CenterStart)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            Text(
                text = "Edit Profile",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.align(Alignment.Center)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Profile picture
        Image(
            painter = painterResource(id = avatars[selectedAvatarId - 1]),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .border(2.dp, primaryColor, CircleShape)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Avatar selection
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            avatars.forEachIndexed { index, avatarResId ->
                Image(
                    painter = painterResource(id = avatarResId),
                    contentDescription = "Avatar ${index + 1}",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .border(
                            width = 2.dp,
                            color = if (selectedAvatarId == index + 1) primaryColor else Color.Gray,
                            shape = CircleShape
                        )
                        .clickable { selectedAvatarId = index + 1 }
                )
            }
        }


        Spacer(modifier = Modifier.height(24.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text("Username") },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 6.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = primaryColor,
                unfocusedBorderColor = Color.LightGray,
                cursorColor = primaryColor
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Update Button
        Button(
            onClick = { authViewModel.updateProfile(username, selectedAvatarId) },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
            contentPadding = PaddingValues(),
            shape = RoundedCornerShape(25.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.horizontalGradient(
                            colors = listOf(primaryColor, Color(0xFF3F51B5))
                        ),
                        shape = RoundedCornerShape(25.dp)
                    ),
                contentAlignment = Alignment.Center
            ) {
                if (updateState == UpdateState.Loading) {
                    CircularProgressIndicator(color = Color.White)
                } else {
                    Text(
                        text = "Update",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
    }
}

// Fungsi Preview
@Preview(showBackground = true, showSystemUi = true)
@Composable
fun EditProfileScreenPreview() {
    val navController = rememberNavController()
    // Mock AuthViewModel for preview
    val authViewModel = AuthViewModel()
    EditProfileScreen(
        navController = navController,
        authViewModel = authViewModel
    )
}
