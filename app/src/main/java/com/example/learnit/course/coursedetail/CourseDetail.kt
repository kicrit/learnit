package com.example.learnit.course.coursedetail

import com.example.learnit.R
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class CourseVideo(
    val id: Int,
    val title: String,
    val description: String,
    val duration: String,
    val gradientColors: List<Color>
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CourseDetailScreen() {
    val listState = rememberLazyListState()
    val scrollOffset = remember { derivedStateOf { listState.firstVisibleItemScrollOffset } }
    val firstVisibleItemIndex = remember { derivedStateOf { listState.firstVisibleItemIndex } }

    // Calculate fade based on scroll position
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
        CourseVideo(
            1,
            "1. Introduction to Web Development",
            "Pengenalan dasar web development dan tools yang akan digunakan",
            "12:45",
            listOf(Color(0xFF667eea), Color(0xFF764ba2))
        ),
        CourseVideo(
            2,
            "2. HTML & CSS Fundamentals",
            "Memahami struktur HTML dan styling dengan CSS",
            "18:32",
            listOf(Color(0xFFf093fb), Color(0xFFf5576c))
        ),
        CourseVideo(
            3,
            "3. JavaScript Basics",
            "Dasar-dasar JavaScript untuk interaktivitas website",
            "25:18",
            listOf(Color(0xFF4facfe), Color(0xFF00f2fe))
        ),
        CourseVideo(
            4,
            "4. Responsive Web Design",
            "Membuat website yang responsif di berbagai perangkat",
            "22:05",
            listOf(Color(0xFF43e97b), Color(0xFF38f9d7))
        ),
        CourseVideo(
            5,
            "5. Node.js & Express Setup",
            "Setup backend dengan Node.js dan Express framework",
            "30:42",
            listOf(Color(0xFFfa709a), Color(0xFFfee140))
        )
    )

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Header Background
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

        // Top Bar Back Button
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
                modifier = Modifier.size(21.dp)
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

            // Course Description Card
            item {
                CourseInfoCard(
                    alpha = descriptionAlpha,
                    scale = descriptionScale
                )
            }

            // Videos Section
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
                            modifier = Modifier.padding(bottom = 20.dp)
                        )
                    }
                }
            }

            items(videos) { video ->
                Box(
                    modifier = Modifier
                        .alpha(videosAlpha)
                        .offset(y = videosTranslationY.dp)
                ) {
                    VideoCard(video = video)
                }
            }

            item {
                Spacer(modifier = Modifier.height(20.dp))
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
            // Title
            Text(
                text = "Web Programming",
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )

            Spacer(modifier = Modifier.height(12.dp))

            // Meta Info
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

            // Description
            Text(
                text = "Kuasai dasar hingga lanjutan pengembangan web modern! Pelajari cara membangun website interaktif dari frontend (HTML, CSS, JavaScript) hingga backend dengan Node.js & Express.",
                fontSize = 14.sp,
                color = Color(0xFF333333),
                lineHeight = 22.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            // Benefits
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

            // Tools
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
fun VideoCard(video: CourseVideo) {
    var isPressed by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 8.dp)
            .clickable {
                isPressed = true
                // Handle video click
            },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFf9fafb)),
        elevation = CardDefaults.cardElevation(
            defaultElevation = if (isPressed) 8.dp else 2.dp
        )
    ) {
        Column {
            // Video Thumbnail
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .background(
                        brush = Brush.linearGradient(
                            colors = video.gradientColors
                        )
                    ),
                contentAlignment = Alignment.Center
            ) {
                // Play Button
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

                // Duration Badge
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

            // Video Info
            Column(
                modifier = Modifier.padding(16.dp)
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
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseDetailPreview() {
    CourseDetailScreen()
}