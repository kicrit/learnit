package com.example.learnit.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun HomeCategory(
    modifier: Modifier = Modifier,
    listCourse: ListCourse,
    onClick: () -> Unit
) {
    Card(
        modifier = modifier
            .padding(16.dp)
            .width(220.dp)
            .height(230.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(18.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column {

            // Thumbnail / Banner
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(110.dp)
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

                // Judul Bold
                Text(
                    text = listCourse.descCourse,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(4.dp))

                // Subjudul
                Text(
                    text = listCourse.descCourse2,
                    fontWeight = FontWeight.Medium,
                    color = Color.Gray
                )

                Spacer(modifier = Modifier.height(10.dp))

                // Badge level
                Box(
                    modifier = Modifier
                        .background(
                            color = Color(0xFFE8EDFF),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = listCourse.progressCourse,
                        color = Color(0xFF131BFF),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}
