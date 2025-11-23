package com.example.learnit.course.course

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnit.component.BottomBar
import com.example.learnit.course.course.component.CourseCategory
import com.example.learnit.course.course.component.CourseTopBar
import com.example.learnit.course.course.model.courseList
import com.example.learnit.course.mycourse.MyCourseViewModel
import com.example.learnit.ui.theme.LearnitTheme


@Composable
fun CoursePage(modifier: Modifier = Modifier, navController: NavController, myCourseViewModel: MyCourseViewModel = viewModel()) {
    val myCourses by myCourseViewModel.myCourses.observeAsState(initial = emptyList())

    Scaffold(bottomBar = { BottomBar(modifier= Modifier, navController) }) { paddingValues ->
        Column (
            modifier = modifier
                .padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CourseTopBar(modifier,navController)

            LazyColumn (
                modifier = Modifier
            ){
                items(courseList) { course ->
                    val enrolledCourse = myCourses.find { it.id == course.id }
                    val updatedCourse = course.copy(progressCourse = enrolledCourse?.progressCourse ?: "0%")

                    CourseCategory(
                        listCourse = updatedCourse,
                        onClick = { navController.navigate("course/${course.id}") }
                    )

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CoursePagePreview() {
    LearnitTheme {
        CoursePage(modifier = Modifier, navController = rememberNavController())
    }
}
