package com.example.learnit.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.learnit.component.BottomBar
import com.example.learnit.home.component.HomeCategory
import com.example.learnit.ui.theme.LearnitTheme
import com.example.learnit.home.component.HomeTopBar
import com.example.learnit.home.component.MentorCategory
import com.example.learnit.home.component.TopMenu
import com.example.learnit.course.mycourse.model.courseList
import com.example.learnit.home.model.mentorList

@Composable
fun HomeScreen(
    navController: NavController) {
    Scaffold(bottomBar = { BottomBar() }) { paddingValues ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            HomeTopBar()
            TopMenu()
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Ongoing Courses",
                    fontWeight = FontWeight.SemiBold)
                Text(text = "SEE ALL >",
                    color = Color(0xFF131BFF),
                    fontWeight = FontWeight.SemiBold)
            }
            LazyRow {
                items(courseList){
                    HomeCategory(listCourse = it)
                }
            }
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = "Top Mentors",
                    fontWeight = FontWeight.SemiBold)
                Text(text = "SEE ALL >",
                    color = Color(0xFF131BFF),
                    fontWeight = FontWeight.SemiBold)
            }
            LazyRow {
                items(mentorList){
                    MentorCategory(listMentor = it)
                }
            }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    LearnitTheme {
        HomeScreen(rememberNavController())
    }
}