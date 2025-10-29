package com.example.learnit.allcategories.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import com.example.learnit.gambar.OrangLagu
import com.example.learnit.gambar.Pelukis
import com.example.learnit.ui.theme.LearnitTheme

data class CategoryItem(
    val title: String,
    val icon: ImageVector
)

@Composable
fun CategoryMenu(
    categories: List<CategoryItem>,
    onCategoryClick: (CategoryItem) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier
            .fillMaxSize()
            .padding(30.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(categories) { category ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
                    .clickable { onCategoryClick(category) },
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        imageVector = category.icon,
                        contentDescription = category.title,
                        modifier = Modifier.size(48.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = category.title,
                        fontSize = 16.sp,
                        textAlign = TextAlign.Center,
                        fontWeight = FontWeight.Medium,
                        color = Color.Black
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CategoryMenuPreview() {
    LearnitTheme {
        val sampleCategories = listOf(
            CategoryItem("3D Design", Pelukis),
            CategoryItem("Arts & Humanities", OrangLagu),
            CategoryItem("Graphic Design", Icons.Default.ArrowBack),
            CategoryItem("Content Editing", Icons.Default.ArrowBack),
            CategoryItem("Programming", Icons.Default.ArrowBack),
            CategoryItem("Photography", Icons.Default.ArrowBack),
            CategoryItem("Marketing", Icons.Default.ArrowBack),
            CategoryItem("Management", Icons.Default.ArrowBack)
        )
        CategoryMenu(categories = sampleCategories)
    }
}

//                Image(
//                    painter = painterResource(id = category.icon),
//                    contentDescription = category.title,
//                    modifier = Modifier.size(48.dp)
//                )