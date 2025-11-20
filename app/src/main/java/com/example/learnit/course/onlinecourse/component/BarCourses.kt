package com.example.learnit.course.onlinecourse.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun BarCourses() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(12.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp, Alignment.CenterHorizontally)
    ) {
        Box(
            modifier = Modifier
                .height(50.dp)
                .width(150.dp)
                .clip(RoundedCornerShape(36.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFE60BFA),
                            Color(0xFF7C13FC),
                            Color(0xFF131BFF)
                        )
                    )
                )
        ) {
            Button(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = Color.White
                ),
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    "Courses",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFE8F1FF),   // warna background button
                contentColor = Color.Black            // warna teks & icon
            ),
            modifier = Modifier
            .width(150.dp)
            .height(50.dp)) {
            Text(
                text = "Mentors",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)
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