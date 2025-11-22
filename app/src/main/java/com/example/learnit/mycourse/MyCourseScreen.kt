package com.example.learnit.course.mycourse

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.learnit.R
import com.example.learnit.course.course.component.CourseCategory
import com.example.learnit.course.course.model.ListCourse

@Composable
fun MyCourseScreen(
    modifier: Modifier,
    navController: NavController,
    viewModel: MyCourseViewModel = viewModel(),
    navBack: () -> Unit
) {
    val myCourses by viewModel.myCourses.observeAsState(emptyList())

    Column(modifier = Modifier.fillMaxSize()) {

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
                    .clickable {navController.navigate("home") }
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
            CourseList(myCourses)
        }
    }
}


@Composable
fun CourseList(list: List<ListCourse>) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(list) { course ->
            CourseCategory(
                listCourse = course,
                onClick = {
                    // TODO → masuk ke CourseDetail
                }
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
            painter = painterResource(id = R.drawable.profile), // gunakan gambar kamu
            contentDescription = null,
            modifier = Modifier.size(150.dp)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "You haven't enrolled any courses yet",
            fontWeight = FontWeight.SemiBold
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Explore courses and start learning!",
            color = androidx.compose.ui.graphics.Color.Gray
        )
    }
}
