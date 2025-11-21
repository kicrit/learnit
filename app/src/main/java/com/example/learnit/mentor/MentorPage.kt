package com.example.learnit.mentor

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.learnit.component.BottomBar
import com.example.learnit.course.course.component.CourseCategory
import com.example.learnit.course.course.model.courseList
import com.example.learnit.mentor.component.BarMentor
import com.example.learnit.mentor.component.MentorTopBar


@Composable
fun MentorPage(modifier: Modifier, navController: NavController) {
    Scaffold(bottomBar = { BottomBar(modifier = Modifier, navController) }) { paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                MentorTopBar()
            }
            item {
                BarMentor()
            }
            items(courseList){course ->
                CourseCategory(listCourse = course,onClick ={})
            }
        }
    }
}

