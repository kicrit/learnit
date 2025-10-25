package com.example.learnit
import com.example.learnit.home.component.TopMenu
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.learnit.home.component.HomeTopBar
import com.example.learnit.ui.theme.LearnitTheme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnitTheme {

            }
        }
    }
}



@Composable
fun LearnIt(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
    ) {
        HomeTopBar()
        TopMenu()
    }
}

@Preview(showBackground = true)
@Composable
fun LearnItPreview(){
    LearnitTheme {
        LearnIt()
    }
}


