package com.example.learnit.course.course

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.learnit.component.BottomBar
import com.example.learnit.course.course.component.CourseCategory
import com.example.learnit.course.course.component.CourseTopBar
import com.example.learnit.course.course.model.courseList


@Composable
fun CoursePage(modifier: Modifier, navController: NavController) {
    Scaffold(bottomBar = { BottomBar(modifier= Modifier, navController) }) { paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                CourseTopBar(modifier,navController)
            }
            itemsIndexed(courseList) { index, course ->
                CourseCategory(
                    listCourse = course,
                    onClick = {
                        when (index) {
                            0 -> navController.navigate("webprogramming")
                            1 -> navController.navigate("course_detail2")
                            2 -> navController.navigate("course_detail3")
                        }
                    }
                )

            }



        }
    }
}

