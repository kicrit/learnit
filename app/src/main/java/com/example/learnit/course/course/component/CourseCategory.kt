package com.example.learnit.course.course.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
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
    val progress = (listCourse.progressCourse
        .removeSuffix("%")
        .toFloatOrNull() ?: 0f) / 100f

    Card(
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            // Banner image style (abu lembut)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color(0xFFF2F2F2),
                                Color(0xFFE0E0E0)
                            )
                        )
                    )
            )

            // Content
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {

                // Title
                Text(
                    text = listCourse.descCourse,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Subtitle
                Text(
                    text = listCourse.descCourse2,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(12.dp))

                // Progress bar
                LinearProgressIndicator(
                    progress = progress,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(6.dp),
                    color = Color(0xFF131BFF),
                    trackColor = Color(0xFFE5E7EB)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Progress badge
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFE8EDFF),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = "${(progress * 100).toInt()}% Complete",
                        color = Color(0xFF131BFF),
                        fontWeight = FontWeight.SemiBold
                    )
                }
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
        progressCourse = "65%",
        category = "Web Development"
    )

    CourseCategory(
        listCourse = sample,
        onClick = {}
    )
}
