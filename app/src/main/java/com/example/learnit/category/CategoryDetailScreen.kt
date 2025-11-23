package com.example.learnit.category
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.learnit.course.course.component.CourseCategory
import com.example.learnit.course.course.model.courseList

@Composable
fun CategoryDetailScreen(navController: NavController, category: String) {
    val filteredCourses = courseList.filter { it.category == category }

    Scaffold(
        topBar = {
            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { navController.popBackStack() }) {
                    Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = category,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            items(filteredCourses) { course ->
                CourseCategory(
                    listCourse = course,
                    onClick = {
                        // Navigate to the correct course detail screen based on ID
                        when (course.id) {
                            1 -> navController.navigate("webprogramming")
                            // You can add navigation for other courses here
                            // 2 -> navController.navigate("course_detail_2")
                            // 3 -> navController.navigate("course_detail_3")
                        }
                    }
                )
            }
        }
    }
}
@Composable
@Preview(showBackground = true)
fun PreviewCategoryDetailScreen() {
    // Gunakan NavController kosong untuk preview
    val navController = rememberNavController()

    CategoryDetailScreen(
        navController = navController,
        category = "Web Programming" // contoh kategori
    )
}