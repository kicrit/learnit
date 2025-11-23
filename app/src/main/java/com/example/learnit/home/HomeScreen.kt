package com.example.learnit.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learnit.auth.AuthState
import com.example.learnit.auth.AuthViewModel
import com.example.learnit.auth.UserViewModel
import com.example.learnit.component.BottomBar
import com.example.learnit.home.component.HomeCategory
import com.example.learnit.home.component.HomeTopBar
import com.example.learnit.home.component.MentorCategory
import com.example.learnit.home.component.TopMenu
import com.example.learnit.course.course.model.courseList
import com.example.learnit.home.model.mentorList

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

    Scaffold(bottomBar = { BottomBar(modifier = Modifier, navController) }) { paddingValues ->
        Column(
            modifier = modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            TextButton(onClick = { authViewModel.signout() }) {
                Text("wenak signout")
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
                items(courseList) {
                    HomeCategory(listCourse = it)
                }
            }


        }
    }

}

