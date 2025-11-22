package com.example.learnit.course.course.component


import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.course.course.model.ListCourse


@Composable
fun CourseCategory(
    modifier: Modifier = Modifier,
    listCourse: ListCourse,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .height(200.dp)
            .clickable{onClick()},
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation( // ini nambah bayangan
            defaultElevation = 10.dp
        ),
        colors = CardDefaults.cardColors(Color.White)

    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .background(Color.Black),

                )
            Column(modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(16.dp)) {
                Text(
                    listCourse.descCourse,
                    color = Color(0xFFFF6B00),
                    fontWeight = FontWeight.Bold
                )
                Text(
                    listCourse.descCourse2,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    listCourse.progressCourse,
                    color = Color(0xFF131BFF),
                    fontWeight = FontWeight.ExtraBold
                )
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CourseCategoryPreview() {
    val sample = ListCourse(
        id = 1,
        descCourse = "Beginner",
        descCourse2 = "Basic Web Development",
        progressCourse = "0%"
    )

    CourseCategory(
        listCourse = sample,
        onClick = {}
    )
}

