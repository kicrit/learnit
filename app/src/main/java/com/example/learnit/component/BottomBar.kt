package com.example.learnit.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.learnit.R
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.learnit.gambar.ChatIcon
import com.example.learnit.gambar.CourseIcon
import com.example.learnit.gambar.HomeIcon
import com.example.learnit.gambar.ProfileIcon
import com.example.learnit.gambar.TaskIcon
import com.example.learnit.model.BottomBarItem
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun BottomBar(
    modifier: Modifier = Modifier) {
    NavigationBar(modifier) {
        val bottomNavigation = listOf(
            BottomBarItem(
                title = "HOME",
                icon = HomeIcon,
                route = "profile"

            ),
            BottomBarItem(
                title = "MY COURSES",
                icon = CourseIcon,
                route = "profile"
            ),
            BottomBarItem(
                title = "CHAT",
                icon = ChatIcon,
                route = "profile"
            ),
            BottomBarItem(
                title = "TASKS",
                icon = TaskIcon,
                route = "profile"

            ),
            BottomBarItem(
                title = "PROFILE",
                icon = ProfileIcon,
                route = "Profile"
            )
        )
        bottomNavigation.map {
            NavigationBarItem(
                selected = it.title == bottomNavigation[0].title,
                onClick = {},
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) }
            )
        }
    }


}

@Preview
@Composable
fun BottomBarPreview() {
    LearnitTheme {
        BottomBar()
    }
}