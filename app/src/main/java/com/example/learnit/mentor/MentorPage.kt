package com.example.learnit.mentor

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.learnit.course.onlinecourse.component.BarCourses
import com.example.learnit.component.BottomBar
import com.example.learnit.course.mycourse.component.MyCourseCategory
import com.example.learnit.course.mycourse.component.MyCourseTopBar
import com.example.learnit.course.mycourse.model.courseList
import com.example.learnit.mentor.component.BarMentor
import com.example.learnit.mentor.component.MentorTopBar
import com.example.learnit.ui.theme.LearnitTheme


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
            items(courseList){
                MyCourseCategory(listCourse = it)
            }
        }
    }
}

