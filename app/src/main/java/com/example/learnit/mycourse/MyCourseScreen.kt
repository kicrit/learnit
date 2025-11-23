package com.example.learnit.mycourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnit.R
import com.example.learnit.component.BottomBar
import com.example.learnit.course.course.component.CourseCategory
import com.example.learnit.course.course.model.ListCourse
import com.example.learnit.course.mycourse.MyCourseViewModel
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun MyCourseScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: MyCourseViewModel = viewModel(),
    navBack: () -> Unit
) {
    val myCourses by viewModel.myCourses.observeAsState(emptyList())

    Scaffold(bottomBar = { BottomBar(modifier = Modifier, navController = navController) }) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {

            // 🔷 TOP BAR
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "Back",
                    modifier = Modifier
                        .size(22.dp)
                        .clickable { navController.navigate("home") }
                )

                Spacer(modifier = Modifier.width(12.dp))

                Text(
                    text = "My Courses",
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }

            // 🔷 LIST or EMPTY
            if (myCourses.isEmpty()) {
                EmptyMyCourse()
            } else {
                CourseList(navController = navController, list = myCourses)
            }
        }
    }
}


@Composable
fun CourseList(navController: NavController, list: List<ListCourse>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) { course ->
            CourseCategory(
                listCourse = course,
                onClick = { navController.navigate("course/${course.id}") }
            )
        }
    }
}


@Composable
fun EmptyMyCourse() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.avatar3), // gunakan gambar kamu
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "You haven\'t enrolled any courses yet",
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Explore courses and start learning!",
            color = Color.Gray
        )
    }
}

@Preview(showBackground = true)
@Composable
fun MyCourseScreenPreview() {
    LearnitTheme {
        MyCourseScreen(modifier = Modifier, navController = rememberNavController(), navBack = {})
    }
}
