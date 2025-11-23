package com.example.learnit.data

import androidx.compose.ui.graphics.Color

data class CourseVideo( // This can be moved from WebProgramming.kt
    val id: Int,
    val title: String,
    val description: String,
    val duration: String,
    val videoId: String
)

data class CourseDetails(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    val level: String,
    val rating: String,
    val students: String,
    val price: String,
    val benefits: List<String>,
    val tools: String,
    val videos: List<CourseVideo>
)

val courseDetailsMap = mapOf(
    1 to CourseDetails(
        id = 1,
        title = "Web Programming",
        description = "Kuasai dasar hingga lanjutan pengembangan web modern! Pelajari cara membangun website interaktif dari frontend (HTML, CSS, JavaScript) hingga backend dengan Node.js & Express.",
        category = "Web Development",
        level = "Beginner - Intermediate",
        rating = "4.2",
        students = "356 Students",
        price = "Rp. 30,000",
        benefits = listOf(
            "Membuat website responsif dari nol",
            "Mengelola data dengan server-side programming",
            "Menerapkan API dan autentikasi pengguna"
        ),
        tools = "Visual Studio Code, Node.js, Express, MySQL / MongoDB",
        videos = listOf(
            CourseVideo(1, "1. Introduction to Web Development", "Pengenalan dasar web development dan tools yang akan digunakan", "12:45", "S0Q4gqBUs7c"),
            CourseVideo(2, "2. HTML & CSS Fundamentals", "Memahami struktur HTML dan styling dengan CSS", "18:32", "91I1wzQv8n8"),
            CourseVideo(3, "3. JavaScript Basics", "Dasar-dasar JavaScript untuk interaktivitas website", "25:18", "W6NZfCO5eJo"),
            CourseVideo(4, "4. Responsive Web Design", "Membuat website yang responsif di berbagai perangkat", "22:05", "srvUrASNj0s"),
            CourseVideo(5, "5. Node.js & Express Setup", "Setup backend dengan Node.js dan Express framework", "30:42", "f2EqECiBClg")
        )
    ),
    // Data kursus lain bisa ditambahkan di sini
    2 to CourseDetails(
        id = 2,
        title = "3D Blender Beginner",
        description = "Pelajari dasar-dasar 3D modeling dan rendering menggunakan Blender, software 3D gratis dan open-source yang sangat powerful.",
        category = "3D Design",
        level = "Beginner",
        rating = "4.5",
        students = "212 Students",
        price = "Rp. 25,000",
        benefits = listOf(
            "Membuat model 3D sederhana",
            "Memahami lighting dan texturing",
            "Mampu melakukan rendering gambar dari model 3D"
        ),
        tools = "Blender",
        videos = listOf(
            CourseVideo(1, "1. Blender UI Introduction", "Pengenalan antarmuka Blender.", "15:10", "nIoXOplUvAw"),
            CourseVideo(2, "2. Basic Modeling", "Membuat objek 3D pertama Anda.", "20:05", "_c4_W3uX_eY")
        )
    )
    // Tambahkan data untuk course ID 3, 4, 5, dst.
)
