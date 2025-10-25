package com.example.learnit.mentor.component

import android.widget.Space
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierLocalBeyondBoundsLayout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.learnit.mentor.model.ListMentorColumn
import com.example.learnit.ui.theme.LearnitTheme


@Composable
fun MentorCategoryColumn(modifier: Modifier = Modifier, listMentorColumn: ListMentorColumn) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .background(Color.Black)
        )
        Spacer(Modifier.size(16.dp))
        Column() {
            Text(text = listMentorColumn.mentorName)
            Text(text = listMentorColumn.courseName)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MentorCategoryColumnPreview() {
    LearnitTheme {
        MentorCategoryColumn(
            listMentorColumn = ListMentorColumn(mentorName = "rmases", courseName = "nglocos")
        )
    }
}