package com.example.learnit.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnit.R
import com.example.learnit.auth.AuthState
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.component.BottomBar

// Mock AuthViewModel for Preview purposes
class MockAuthViewModel : ViewModel() {
    val authState = MutableLiveData<AuthState>(AuthState.Authenticated)
    val userData = MutableLiveData<Map<String, Any?>>(
        mapOf(
            "username" to "John Doe",
            "email" to "john.doe@example.com"
        )
    )

    fun loadUserData() {
        // Mock implementation for preview
    }

    fun signout() {
        // Mock implementation for preview
    }
}


@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier, // Added default value for modifier for better reusability
    navController: NavController, authViewModel: AuthViewModel
) {

    val authState = authViewModel.authState.observeAsState()
    val userData = authViewModel.userData.observeAsState()

    LaunchedEffect(true) {
        authViewModel.loadUserData()
    }
    Scaffold(
        bottomBar = { BottomBar(modifier = Modifier, navController = navController) }
    ) { paddingValues ->
        Column(
            modifier = modifier // Use the passed modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // 🔹 Header
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
                    text = "Profile",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.Center)
                )
            }

            Spacer(modifier = Modifier.height(40.dp))


            Image(
                painter = painterResource(id = R.drawable.profile),
                contentDescription = null,
                modifier = Modifier
                    .size(120.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Blue, CircleShape)
            )

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                userData.value?.get("username") as? String ?: "Loading...",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                userData.value?.get("email") as? String ?: "",
                color = Color.Gray,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                ) {
                    ProfileOption(
                        icon = Icons.Default.Person,
                        text = "Edit Profile",
                        onClick = { navController.navigate("editProfile") }
                    )

                    // Spacer moved outside the main options to be above the Logout button
                    Spacer(modifier = Modifier.height(48.dp)) // Added space

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                authViewModel.signout()           // SIGN OUT
                                navController.navigate("login") { // Arahkan ke screen login
                                    popUpTo(0)                    // Hapus semua history
                                }
                            }
                            .padding(vertical = 12.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Logout",
                            tint = Color.Black
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Logout",
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ProfileOption(
    icon: ImageVector,
    text: String,
    onClick: () -> Unit = {}
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(icon, contentDescription = null, tint = Color.Black)
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = text,
            fontSize = 16.sp,
            modifier = Modifier.weight(1f)
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Next",
            tint = Color.Gray
        )
    }
}

// Tambahkan fungsi Preview di sini
@Preview(showBackground = true)
@Composable
fun ProfileScreenPreview() {

    val navController = rememberNavController()

    val mockAuthViewModel = remember { MockAuthViewModel() }

    // Memanggil composable yang ingin dipreview
    ProfileScreen(
        modifier = Modifier,
        navController = navController,
        authViewModel = mockAuthViewModel as AuthViewModel
    )
}
