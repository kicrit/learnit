package com.example.learnit.course.coursedetail

import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import com.example.learnit.R
import com.example.learnit.course.course.model.ListCourse
import com.example.learnit.course.mycourse.MyCourseViewModel

data class CourseVideo(
    val id: Int,
    val title: String,
    val description: String,
    val duration: String,
    val gradientColors: List<Color>,
    val videoId: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WebProgramming(modifier: Modifier = Modifier, navController: NavController) {
    val listState = rememberLazyListState()
    val scrollOffset = remember { derivedStateOf { listState.firstVisibleItemScrollOffset } }
    val firstVisibleItemIndex = remember { derivedStateOf { listState.firstVisibleItemIndex } }
    val myCourseVM: MyCourseViewModel = viewModel()
    val context = LocalContext.current

    val myCourses by myCourseVM.myCourses.observeAsState(initial = emptyList())
    val isEnrolled = remember(myCourses) {
        myCourses.any { it.id == 1 } // ID 1 for Web Programming
    }

    val videoCompletion by myCourseVM.videoCompletion.observeAsState(initial = emptyMap())
    val progress = videoCompletion.count { it.value }.toFloat() / 5f // 5 total videos

    val descriptionAlpha by animateFloatAsState(
        targetValue = if (firstVisibleItemIndex.value > 0 || scrollOffset.value > 300) 0f else 1f,
        animationSpec = tween(durationMillis = 300),
        label = "description_alpha"
    )

    val descriptionScale by animateFloatAsState(
        targetValue = if (firstVisibleItemIndex.value > 0 || scrollOffset.value > 300) 0.95f else 1f,
        animationSpec = tween(durationMillis = 300),
        label = "description_scale"
    )

    val videosAlpha by animateFloatAsState(
        targetValue = if (firstVisibleItemIndex.value > 0 || scrollOffset.value > 300) 1f else 0f,
        animationSpec = tween(durationMillis = 400),
        label = "videos_alpha"
    )

    val videosTranslationY by animateFloatAsState(
        targetValue = if (firstVisibleItemIndex.value > 0 || scrollOffset.value > 300) 0f else 40f,
        animationSpec = tween(durationMillis = 400),
        label = "videos_translation"
    )

    val videos = listOf(
        CourseVideo(1, "1. Introduction to Web Development", "Pengenalan dasar web development dan tools yang akan digunakan", "12:45", listOf(Color(0xFF667eea), Color(0xFF764ba2)), "S0Q4gqBUs7c"),
        CourseVideo(2, "2. HTML & CSS Fundamentals", "Memahami struktur HTML dan styling dengan CSS", "18:32", listOf(Color(0xFFf093fb), Color(0xFFf5576c)), "91I1wzQv8n8"),
        CourseVideo(3, "3. JavaScript Basics", "Dasar-dasar JavaScript untuk interaktivitas website", "25:18", listOf(Color(0xFF4facfe), Color(0xFF00f2fe)), "W6NZfCO5eJo"),
        CourseVideo(4, "4. Responsive Web Design", "Membuat website yang responsif di berbagai perangkat", "22:05", listOf(Color(0xFF43e97b), Color(0xFF38f9d7)), "srvUrASNj0s"),
        CourseVideo(5, "5. Node.js & Express Setup", "Setup backend dengan Node.js dan Express framework", "30:42", listOf(Color(0xFFfa709a), Color(0xFFfee140)), "f2EqECiBClg")
    )

    Box(
        modifier = modifier.fillMaxSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1a1a1a),
                            Color(0xFF0a0a0a)
                        )
                    )
                )
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp, start = 20.dp, end = 20.dp)
                .align(Alignment.TopStart),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.back),
                contentDescription = null,
                modifier = Modifier
                    .size(21.dp)
                    .clickable { navController.popBackStack() }
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = "Course Detail",
                color = Color.White,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        }

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            item {
                Spacer(modifier = Modifier.height(240.dp))
            }

            item {
                CourseInfoCard(
                    alpha = descriptionAlpha,
                    scale = descriptionScale
                )
            }

            item {
                Box(
                    modifier = Modifier
                        .alpha(videosAlpha)
                        .offset(y = videosTranslationY.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White)
                            .padding(24.dp)
                    ) {
                        Text(
                            text = "Course Videos",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.Black,
                            modifier = Modifier.padding(bottom = 8.dp)
                        )
                        LinearProgressIndicator(
                            progress = progress,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

            items(videos) { video ->
                val isCompleted = videoCompletion[video.id] == true
                Box(
                    modifier = Modifier
                        .alpha(videosAlpha)
                        .offset(y = videosTranslationY.dp)
                ) {
                    VideoCard(video = video, isCompleted = isCompleted, onVideoClick = {
                        if (isEnrolled) {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${video.videoId}"))
                            context.startActivity(intent)
                        } else {
                            Toast.makeText(context, "Please enroll to watch the videos", Toast.LENGTH_SHORT).show()
                        }
                    }, onCheckChange = {
                        myCourseVM.toggleVideoCompletion(1, video.id)
                    })
                }
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color.White)
                .padding(20.dp)
        ) {
            Button(
                onClick = {
                    if (!isEnrolled) {
                        val course = ListCourse(
                            id = 1, // <-- ID for Web Programming
                            descCourse = "Web Programming",
                            descCourse2 = "Complete Web Programming",
                            progressCourse = "0%",
                            category = "Web Development" // Added category
                        )
                        myCourseVM.enrollCourse(
                            course = course,
                            onSuccess = {
                                navController.navigate("mycourse")
                            },
                            onFail = { msg ->
                                println("ENROLL ERROR: $msg")
                            }
                        )
                    }
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = if (isEnrolled) Color(0xFF4CAF50) else Color(0xFF1a73e8),
                    disabledContainerColor = Color(0xFF4CAF50)
                ),
                enabled = !isEnrolled
            ) {
                Text(
                    text = if (isEnrolled) "Enrolled" else "Enroll Now",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

    }
}

@Composable
fun CourseInfoCard(alpha: Float, scale: Float) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .alpha(alpha)
            .scale(scale)
            .padding(horizontal = 0.dp),
        shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(24.dp)
        ) {
            Text(
                text = "Web Programming",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(
                    text = "Rp. 30,000",
                    fontSize = 14.sp,
                    color = Color(0xFF666666)
                )
                Text(text = "|", color = Color(0xFF666666))
                Text(
                    text = "⭐ 4.2",
                    fontSize = 14.sp,
                    color = Color(0xFFf59e0b),
                    fontWeight = FontWeight.SemiBold
                )
                Text(text = "|", color = Color(0xFF666666))
                Text(
                    text = "356 Students",
                    fontSize = 14.sp,
                    color = Color(0xFF666666)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Level: Beginner - Intermediate",
                fontSize = 14.sp,
                color = Color(0xFF888888),
                fontStyle = FontStyle.Italic
            )

            Spacer(modifier = Modifier.height(20.dp))

            HorizontalDivider(color = Color(0xFFe5e5e5))

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Kuasai dasar hingga lanjutan pengembangan web modern! Pelajari cara membangun website interaktif dari frontend (HTML, CSS, JavaScript) hingga backend dengan Node.js & Express.",
                fontSize = 14.sp,
                color = Color(0xFF333333),
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Setelah menyelesaikan kursus ini, kamu akan bisa:",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            BenefitItem("Membuat website responsif dari nol")
            BenefitItem("Mengelola data dengan server-side programming")
            BenefitItem("Menerapkan API dan autentikasi pengguna")

            Spacer(modifier = Modifier.height(24.dp))

            Row {
                Text(
                    text = "Tools yang digunakan: ",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )
                Text(
                    text = "Visual Studio Code, Node.js, Express, MySQL / MongoDB",
                    fontSize = 14.sp,
                    color = Color(0xFF333333)
                )
            }
        }
    }
}

@Composable
fun BenefitItem(text: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text(
            text = "•",
            fontSize = 20.sp,
            color = Color(0xFFd4af37),
            modifier = Modifier.padding(end = 12.dp)
        )
        Text(
            text = text,
            fontSize = 14.sp,
            color = Color(0xFF444444),
            lineHeight = 20.sp
        )
    }
}

@Composable
fun VideoCard(video: CourseVideo, isCompleted: Boolean, onVideoClick: () -> Unit, onCheckChange: (Boolean) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clickable { onVideoClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFf9fafb)),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = "https://img.youtube.com/vi/${video.videoId}/0.jpg",
                    contentDescription = "Video thumbnail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.White.copy(alpha = 0.9f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Play",
                        tint = Color(0xFF333333),
                        modifier = Modifier.size(32.dp)
                    )
                }

                Surface(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(12.dp),
                    shape = RoundedCornerShape(4.dp),
                    color = Color.Black.copy(alpha = 0.8f)
                ) {
                    Text(
                        text = video.duration,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp)
                    )
                }
            }

            Row(
                modifier = Modifier.padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = video.title,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.Black
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = video.description,
                        fontSize = 14.sp,
                        color = Color(0xFF666666),
                        lineHeight = 20.sp
                    )
                }
                Checkbox(
                    checked = isCompleted,
                    onCheckedChange = onCheckChange
                )
            }
        }
    }
}


@Composable
fun WebProgrammingPreviewOnly() {
    WebProgramming(
        modifier = Modifier,
        navController = rememberNavController()
    )
}

@Preview(showBackground = true)
@Composable
fun CourseDetailPreview() {
    WebProgrammingPreviewOnly()
}
