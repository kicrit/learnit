package com.example.learnit.home.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learnit.gambar.Kotak
import com.example.learnit.gambar.OrangLagu
import com.example.learnit.gambar.Pelukis
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun TopMenu(modifier: Modifier = Modifier, navController: NavController) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Categories",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
                TextButton(onClick = { navController.navigate("categories") }) {
                    Text(
                        text = "SEE ALL >",
                        color = Color(0xFF131BFF),
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Categories Row
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                CategoryItem(
                    icon = Kotak,
                    label = "3D Design",
                    bgColor = Color(0xFFD7E8FF),
                    onClick = { navController.navigate("category/3D Design") }
                )
                CategoryItem(
                    icon = OrangLagu,
                    label = "Art & Humanities",
                    bgColor = Color(0xFFE8D7FF),
                    onClick = { navController.navigate("category/Art & Humanities") }
                )
                CategoryItem(
                    icon = Pelukis,
                    label = "Graphic Design",
                    bgColor = Color(0xFFD7FFE0),
                    onClick = { navController.navigate("category/Graphic Design") }
                )
            }
        }
    }
}

@Composable
fun CategoryItem(
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    label: String,
    bgColor: Color,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable { onClick() }
    ) {
        Card(
            colors = CardDefaults.cardColors(containerColor = bgColor),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
            shape = MaterialTheme.shapes.extraLarge,
            modifier = Modifier.size(56.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = null,
                    modifier = Modifier.size(28.dp)
                )
            }
        }

        Text(
            text = label,
            fontSize = 12.sp,
            modifier = Modifier
                .padding(top = 6.dp)
                .widthIn(max = 90.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun TopMenuPreview() {
    LearnitTheme {
        val nav = androidx.navigation.compose.rememberNavController()
        TopMenu(navController = nav)
    }
}
