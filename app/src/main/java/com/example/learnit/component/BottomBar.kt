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
import com.example.learnit.model.BottomBarItem
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun BottomBar(modifier: Modifier = Modifier) {
    NavigationBar(modifier) {
        val bottomNavigation = listOf(
            BottomBarItem(
                title = "Home",
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = "Home",
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = "Home",
                icon = Icons.Default.Home
            ),
            BottomBarItem(
                title = "Home",
                icon = Icons.Default.Home
            )
        )
        bottomNavigation.map {
            NavigationBarItem(
                selected = it.title == bottomNavigation[0].title,
                onClick = {},
                icon = { Icon(imageVector = it.icon, contentDescription = it.title)}
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