package com.example.learnit.course.mycourse

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learnit.course.onlinecourse.component.BarCourses
import com.example.learnit.component.BottomBar
import com.example.learnit.course.mycourse.component.MyCourseCategory
import com.example.learnit.course.mycourse.component.MyCourseTopBar
import com.example.learnit.course.mycourse.model.courseList
import com.example.learnit.mentor.component.MentorCategoryColumn
import com.example.learnit.mentor.model.columnMentorList
import com.example.learnit.ui.theme.LearnitTheme


@Composable
fun MyCoursePage() {
    Scaffold(bottomBar = { BottomBar() }) { paddingValues ->
        LazyColumn (
            modifier = Modifier
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                MyCourseTopBar()
            }
            item {
                BarCourses()
            }
            items(columnMentorList){
                MentorCategoryColumn(listMentorColumn = it)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyCoursePagePreview(){
    LearnitTheme {
        MyCoursePage()
    }
}