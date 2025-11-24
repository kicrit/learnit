package com.example.learnit.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learnit.auth.AuthState
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.auth.UserViewModel
import com.example.learnit.component.BottomBar
import com.example.learnit.course.course.model.courseList
import com.example.learnit.home.component.HomeCategory
import com.example.learnit.home.component.HomeTopBar
import com.example.learnit.home.component.TopMenu

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    authViewModel: AuthViewModel,
    userViewModel : UserViewModel
) {

    val authState = authViewModel.authState.observeAsState()
    val username = userViewModel.username.observeAsState("User")

    LaunchedEffect(authState.value) {
        when (authState.value) {
            is AuthState.Unauthenticated -> navController.navigate("login")
            else -> Unit
        }
    }

    Scaffold(
        bottomBar = { BottomBar(modifier = Modifier, navController) }
    ) { paddingValues ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {

            // === iOS Style Sign Out Button ===
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFFFF1F0),
                            shape = RoundedCornerShape(14.dp)
                        )
                        .clickable { authViewModel.signout() }
                        .padding(horizontal = 16.dp, vertical = 10.dp)
                ) {
                    Text(
                        text = "Sign Out",
                        color = Color(0xFFD93025),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            HomeTopBar(username.value)
            TopMenu(modifier, navController)

            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Ongoing Courses",
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "SEE ALL >",
                    color = Color(0xFF131BFF),
                    fontWeight = FontWeight.SemiBold
                )
            }

            LazyRow {
                items(courseList) { course ->
                    HomeCategory(listCourse = course) {
                        navController.navigate("course/${course.id}")
                    }
                }
            }
        }
    }
}
