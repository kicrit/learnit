package com.example.learnit.booking.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.ui.theme.LearnitTheme


@Composable
fun BookingAbout() {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFE2E6EA)) // background luar
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier
                .background(Color.White) // container putih
                .clip(RoundedCornerShape(16.dp))
                .padding(16.dp)
        ) {

            // ====================
            // SECTION: TOP BUTTONS
            // ====================
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(
                        brush = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFFE60BFA),
                                Color(0xFF7C13FC),
                                Color(0xFF131BFF)
                            )
                        )
                    )
                    .height(70.dp),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFF00035D),
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .width(135.dp)
                            .height(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Text("About", fontWeight = FontWeight.Bold)
                    }

                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color.Transparent,
                            contentColor = Color.White
                        ),
                        modifier = Modifier
                            .width(135.dp)
                            .height(50.dp)
                            .clip(RoundedCornerShape(10.dp))
                    ) {
                        Text("Available Slot", fontWeight = FontWeight.Bold)
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ====================
            // 1. BOX TEXT ABOUT
            // ====================
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF5F5F7))
                    .padding(16.dp)
            ) {
                Text(
                    text = "Samuel adeputra adalah orang hanya memiliki uang 1500 dengan motornya yang bensinnya selalu kedap kedip",
                    color = Color.Black
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ====================
            // 2. TEXT BOLD WORK EXPERIENCE
            // ====================
            Text(
                text = "Work Experience",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ====================
            // 3. HORIZONTAL SCROLL BOXES
            // ====================
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
            ) {
                repeat(5) {
                    Box(
                        modifier = Modifier
                            .size(140.dp, 50.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(Color(0xFFEEF1F4))
                            .padding(10.dp)
                            .padding(end = 12.dp)
                    ) {
                        Text("Item ${it + 1}")
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // ====================
            // 4. TEXT BOLD WORK EXPERIENCE (KE-2)
            // ====================
            Text(
                text = "Work Experience",
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // ====================
            // 5. VERTICAL SCROLL BOX LIST
            // ====================
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(Color(0xFFF4F4F6))
                    .verticalScroll(rememberScrollState())
                    .padding(12.dp)
            ) {

                repeat(6) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 10.dp)
                            .clip(RoundedCornerShape(10.dp))
                            .background(Color.White)
                            .padding(12.dp)
                    ) {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.Start
                        ) {
                            Text(
                                text = "PT BADAK ${it + 1}",
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                            Text(
                                text = "Design ${it + 1}.",
                                color = Color.DarkGray
                            )
                            Text(
                                text = "2010-2022 ${it + 1}.",
                                color = Color.Gray
                            )
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // ====================
            // 6. SCHEDULE MEETING BOX
            // ====================
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFF131BFF))
                    .padding(20.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = "Schedule Meeting",
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )

                    // Arrow dalam lingkaran
                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(RoundedCornerShape(50))
                            .background(Color.White)
                            .padding(8.dp)
                    ) {
                        Text(
                            text = "→",
                            color = Color(0xFF131BFF),
                            modifier = Modifier.align(Alignment.Center),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
            }

        }
    }
}



@Preview(showBackground = true)
@Composable
fun BookingAboutPreview() {
    LearnitTheme {
        BookingAbout()
    }
}