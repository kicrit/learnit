package com.example.learnit.home.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.learnit.R
import com.example.learnit.gambar.Kotak
import com.example.learnit.gambar.OrangLagu
import com.example.learnit.gambar.Pelukis
import com.example.learnit.gambar.SearchHitam
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun TopMenu(modifier: Modifier = Modifier, navController : NavController) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        elevation = CardDefaults.cardElevation( // ini nambah bayangan
            defaultElevation = 10.dp
        ),
        modifier = Modifier.padding(16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // header categori sama see all
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
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
                Row(
                    modifier = Modifier,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                }
                Row(
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(24.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { navController.navigate("category/3D Design") }
                    ) {
                        Icon(
                            imageVector = Kotak,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                        )
                        Text(
                            text = "3D Design",
                            modifier = Modifier.widthIn(max = 100.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { navController.navigate("category/Art & Humanities") }
                    ) {
                        Icon(
                            imageVector = OrangLagu,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                        )
                        Text(
                            text = "Art & Humanities",
                            modifier = Modifier.widthIn(max = 100.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.clickable { navController.navigate("category/Graphic Design") }
                    ) {
                        Icon(
                            imageVector = Pelukis,
                            contentDescription = null,
                            modifier = Modifier.size(32.dp),
                        )
                        Text(
                            text = "Graphic Design",
                            modifier = Modifier.widthIn(max = 100.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }


                /*LazyRow(
                modifier = Modifier
                    .padding(top = 16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(24.dp)

            ) {
                items(
                    listOf(
                        "3D Design",
                        "Art & Humanities",
                        "Graphic Design",
                    )
                )
                { category ->
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.back),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)

                        )
                        Text(
                            text = category,
                            modifier = Modifier.widthIn(max = 100.dp),
                            textAlign = TextAlign.Center
                        )
                    }
                }*/


            }


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
