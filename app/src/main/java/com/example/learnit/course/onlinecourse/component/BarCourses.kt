package com.example.learnit.course.onlinecourse.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun BarCourses() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        Button(onClick = {}, modifier = Modifier.width(150.dp)) {
            Text(text = "Courses")
        }
        Button(onClick = {}, modifier = Modifier.width(150.dp)) {
            Text(text = "Mentors")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun BarCoursesPreview() {
    LearnitTheme {
        BarCourses()
    }
}