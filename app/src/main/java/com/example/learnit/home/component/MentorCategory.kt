package com.example.learnit.home.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.home.model.ListMentor
import com.example.learnit.ui.theme.LearnitTheme

@Composable
fun MentorCategory(modifier: Modifier=Modifier, listMentor: ListMentor) {
    Column(modifier = Modifier.padding(16.dp)) {
        Box(modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(Color.Black)
        )
        Text(text = listMentor.descMentor)
    }
}

@Preview(showBackground = true)
@Composable
fun MentorCategoryPreview() {
    LearnitTheme {
        MentorCategory(
            listMentor = ListMentor(descMentor = "Matematika")
        )
    }
}