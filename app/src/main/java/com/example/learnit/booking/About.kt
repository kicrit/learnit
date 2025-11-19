package com.example.learnit.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.booking.component.BookingAbout
import com.example.learnit.booking.component.TopBarBooking
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun About(){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFE2E6EA)),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(Modifier.padding(20.dp))
        TopBarBooking()
        BookingAbout()
    }

}


@Composable
@Preview(showBackground = true)
fun AboutPreview(){
    LearnitTheme {
        About()
    }
}