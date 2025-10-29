package com.example.learnit.home.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.learnit.R
import com.example.learnit.gambar.NOTIFICATIONS
import com.example.learnit.gambar.SearchHitam
import com.example.learnit.ui.theme.LearnitTheme


@Composable
fun HomeTopBar() {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        )
        {
            Column {
                Text(
                    text = "Hi, Pak Tua Jenkins", fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "Mau belajar apa hari ini?", fontSize = 13.sp,
                )
            }
            Icon(
                imageVector = NOTIFICATIONS,
                contentDescription = null,
                modifier = Modifier.size(32.dp),
            )
        }
        Spacer(modifier = Modifier.padding(16.dp))
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = "",
            onValueChange = {},
            leadingIcon = {
                Icon(
                    imageVector = SearchHitam,
                    contentDescription = null,
                    modifier = Modifier.size(32.dp),
                )

            },
            placeholder = { Text(text = "Search") }
        )
    }
}


@Preview(showBackground = true)
@Composable
fun HomeTopBarPreview() {
    LearnitTheme {
        HomeTopBar()
    }
}