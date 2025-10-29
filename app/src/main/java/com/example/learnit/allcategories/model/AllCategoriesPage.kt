package com.example.learnit.allcategories.model

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.allcategories.component.CategoryItem
import com.example.learnit.allcategories.component.CategoryMenu
import com.example.learnit.allcategories.component.TopBar
import com.example.learnit.gambar.OrangLagu
import com.example.learnit.gambar.Pelukis
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun AllCategoriesPage(
    onBackClick: () -> Unit = {}
) {
    val categories = listOf(
        CategoryItem("3D Design", Pelukis),
        CategoryItem("Arts & Humanities", OrangLagu),
        CategoryItem("Graphic Design", Icons.Filled.ArrowBack),
        CategoryItem("Content Editing", Icons.Filled.ArrowBack),
        CategoryItem("Programming", Icons.Filled.ArrowBack),
        CategoryItem("Photography", Icons.Filled.ArrowBack),
        CategoryItem("Marketing", Icons.Filled.ArrowBack),
        CategoryItem("Management", Icons.Filled.ArrowBack),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TopBar(
            title = "All Categories",
            onBackClick = onBackClick
        )
        CategoryMenu(categories = categories)
    }
}

@Preview(showBackground = true)
@Composable
fun AllCategoriesPagePreview() {
    LearnitTheme {
        AllCategoriesPage()
    }
}
