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
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.learnit.course.course.model.ListCourse
import com.example.learnit.course.mycourse.MyCourseViewModel
import com.example.learnit.data.CourseDetails
import com.example.learnit.data.CourseVideo
import com.example.learnit.data.courseDetailsMap

@Composable
fun CourseDetailScreen(navController: NavController, courseId: Int) {
    val courseDetails = courseDetailsMap[courseId]

    if (courseDetails == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Course not found!")
        }
        return
    }

    val listState = rememberLazyListState()
    val scrollOffset = remember { derivedStateOf { listState.firstVisibleItemScrollOffset } }
    val firstVisibleItemIndex = remember { derivedStateOf { listState.firstVisibleItemIndex } }
    val myCourseVM: MyCourseViewModel = viewModel()
    val context = LocalContext.current

    val myCourses by myCourseVM.myCourses.observeAsState(initial = emptyList())
    val isEnrolled = remember(myCourses, courseId) {
        myCourses.any { it.id == courseId }
    }

    LaunchedEffect(courseId) {
        myCourseVM.loadVideoCompletionState(courseId)
    }
    val videoCompletion by myCourseVM.videoCompletion.observeAsState(initial = emptyMap())
    val progress = if (courseDetails.videos.isNotEmpty()) {
        videoCompletion.count { it.value }.toFloat() / courseDetails.videos.size.toFloat()
    } else 0f

    // Calculate scroll progress for animations (0 to 1)
    val scrollProgress = remember {
        derivedStateOf {
            if (firstVisibleItemIndex.value == 0) {
                (scrollOffset.value.toFloat() / 300f).coerceIn(0f, 1f)
            } else {
                1f
            }
        }
    }

    // Header image fade out
    val headerImageAlpha by animateFloatAsState(
        targetValue = 1f - scrollProgress.value,
        animationSpec = tween(durationMillis = 200),
        label = "header_image_alpha"
    )

    // Course title in body fade out
    val bodyTitleAlpha by animateFloatAsState(
        targetValue = 1f - scrollProgress.value,
        animationSpec = tween(durationMillis = 200),
        label = "body_title_alpha"
    )

    // Course title in header fade in
    val headerTitleAlpha by animateFloatAsState(
        targetValue = scrollProgress.value,
        animationSpec = tween(durationMillis = 200),
        label = "header_title_alpha"
    )

    Box(modifier = Modifier.fillMaxSize()) {
        // Fixed header image at top (fades out on scroll) - MOVED HERE FIRST
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .alpha(headerImageAlpha)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF1a1a1a),
                            Color(0xFF0a0a0a)
                        )
                    )
                )
        )

        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize()
        ) {
            // Spacer for header image area - smaller to show more white card
            item {
                Spacer(modifier = Modifier.height(120.dp))
            }

            // White card with course info
            item {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(modifier = Modifier.padding(24.dp)) {
                        // Course title that fades out on scroll
                        Text(
                            text = courseDetails.title,
                            style = MaterialTheme.typography.headlineMedium,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.alpha(bodyTitleAlpha)
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        // Price, Rating, Students row
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.alpha(bodyTitleAlpha)
                        ) {
                            Text(text = courseDetails.price, fontSize = 14.sp, color = Color(0xFF666666))
                            Text(text = "|", color = Color(0xFF666666))
                            Text(text = "⭐ ${courseDetails.rating}", fontSize = 14.sp, color = Color(0xFFf59e0b), fontWeight = FontWeight.SemiBold)
                            Text(text = "|", color = Color(0xFF666666))
                            Text(text = courseDetails.students, fontSize = 14.sp, color = Color(0xFF666666))
                        }

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Level: ${courseDetails.level}",
                            fontSize = 14.sp,
                            color = Color(0xFF888888),
                            fontStyle = FontStyle.Italic,
                            modifier = Modifier.alpha(bodyTitleAlpha)
                        )

                        Spacer(modifier = Modifier.height(20.dp))
                        HorizontalDivider(color = Color(0xFFe5e5e5))
                        Spacer(modifier = Modifier.height(20.dp))
                        Text(text = courseDetails.description, style = MaterialTheme.typography.bodyMedium, lineHeight = 22.sp)
                        Spacer(modifier = Modifier.height(24.dp))
                        Text(text = "Setelah menyelesaikan kursus ini, kamu akan bisa:", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                        Spacer(modifier = Modifier.height(12.dp))
                        courseDetails.benefits.forEach { DetailBenefitItem(it) }
                        Spacer(modifier = Modifier.height(24.dp))
                        Row {
                            Text(text = "Tools yang digunakan: ", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            Text(text = courseDetails.tools, fontSize = 14.sp, color = Color(0xFF333333))
                        }
                    }
                }
            }

            // Course Videos section
            item {
                Column(
                    modifier = Modifier
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

            // Video list
            items(courseDetails.videos) { video ->
                val isCompleted = videoCompletion[video.id] == true
                Box(modifier = Modifier.background(Color.White)) {
                    VideoCard(video = video, isCompleted = isCompleted, onVideoClick = {
                        if (isEnrolled) {
                            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=${video.videoId}"))
                            context.startActivity(intent)
                        } else {
                            Toast.makeText(context, "Please enroll to watch the videos", Toast.LENGTH_SHORT).show()
                        }
                    }, onCheckChange = {
                        myCourseVM.toggleVideoCompletion(courseId, video.id)
                    })
                }
            }

            item {
                Spacer(modifier = Modifier.height(100.dp))
            }
        }

        // Top header bar with white background that appears on scroll
        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter),
            color = Color.White.copy(alpha = scrollProgress.value),
            shadowElevation = if (scrollProgress.value > 0.5f) 4.dp else 0.dp
        ) {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 40.dp, bottom = 12.dp, start = 20.dp, end = 20.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = if (scrollProgress.value > 0.5f) Color.Black else Color.White
                        )
                    }
                    Spacer(modifier = Modifier.width(12.dp))

                    // Title that fades in on scroll
                    Box(modifier = Modifier.weight(1f)) {
                        // "Course Detail" text - fades out
                        Text(
                            text = "Course Detail",
                            color = Color.White,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.alpha(1f - headerTitleAlpha)
                        )

                        // Course title - fades in
                        Text(
                            text = courseDetails.title,
                            color = Color.Black,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.alpha(headerTitleAlpha)
                        )
                    }
                }
                // Bottom border line
                if (scrollProgress.value > 0.5f) {
                    HorizontalDivider(
                        color = Color(0xFFe5e5e5),
                        thickness = 1.dp
                    )
                }
            }
        }

        // Bottom enroll button
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
                            id = courseDetails.id,
                            descCourse = courseDetails.title,
                            descCourse2 = courseDetails.description.take(50) + "...",
                            progressCourse = "0%",
                            category = courseDetails.category
                        )
                        myCourseVM.enrollCourse(
                            course = course,
                            onSuccess = { navController.navigate("mycourse") },
                            onFail = { msg -> println("ENROLL ERROR: $msg") }
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
private fun DetailBenefitItem(text: String) {
    Row(
        modifier = Modifier.padding(vertical = 4.dp),
        verticalAlignment = Alignment.Top
    ) {
        Text("•", fontSize = 20.sp, color = Color(0xFFd4af37), modifier = Modifier.padding(end = 12.dp))
        Text(text = text, style = MaterialTheme.typography.bodyMedium, lineHeight = 20.sp)
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
                modifier = Modifier.height(180.dp).fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = "https://img.youtube.com/vi/${video.videoId}/0.jpg",
                    contentDescription = "Video thumbnail",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
                Box(
                    modifier = Modifier.size(60.dp).clip(CircleShape).background(Color.White.copy(alpha = 0.9f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.PlayArrow, contentDescription = "Play", tint = Color(0xFF333333), modifier = Modifier.size(32.dp))
                }
                Surface(
                    modifier = Modifier.align(Alignment.BottomEnd).padding(12.dp),
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
                Column(modifier = Modifier.weight(1f)) {
                    Text(video.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(video.description, style = MaterialTheme.typography.bodyMedium, color = Color.Gray, lineHeight = 20.sp)
                }
                Checkbox(checked = isCompleted, onCheckedChange = onCheckChange)
            }
        }
    }
}