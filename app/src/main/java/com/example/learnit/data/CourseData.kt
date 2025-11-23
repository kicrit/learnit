package com.example.learnit.data

import androidx.compose.ui.graphics.Color

// Data model for a single video in a course
data class CourseVideo(
    val id: Int,
    val title: String,
    val description: String,
    val duration: String,
    val videoId: String
)

// Data model for the complete details of a course
data class CourseDetails(
    val id: Int,
    val title: String,
    val description: String,
    val price: String,
    val rating: String,
    val students: String,
    val level: String,
    val benefits: List<String>,
    val tools: String,
    val videos: List<CourseVideo>,
    val category: String
)

// The single source of truth for all course details
val courseDetailsMap = mapOf(
    1 to CourseDetails(
        id = 1,
        title = "Web Programming",
        description = "Kuasai dasar hingga lanjutan pengembangan web modern! Pelajari cara membangun website interaktif dari frontend (HTML, CSS, JavaScript) hingga backend dengan Node.js & Express.",
        price = "Rp. 30,000",
        rating = "4.2",
        students = "356 Students",
        level = "Beginner - Intermediate",
        benefits = listOf(
            "Membuat website responsif dari nol",
            "Mengelola data dengan server-side programming",
            "Menerapkan API dan autentikasi pengguna"
        ),
        tools = "Visual Studio Code, Node.js, Express, MySQL/MongoDB",
        videos = listOf(
            CourseVideo(1, "1. Introduction to Web Development", "Pengenalan dasar web development dan tools.", "12:45", "S0Q4gqBUs7c"),
            CourseVideo(2, "2. HTML & CSS Fundamentals", "Memahami struktur HTML dan styling CSS.", "18:32", "91I1wzQv8n8"),
            CourseVideo(3, "3. JavaScript Basics", "Dasar-dasar JavaScript untuk interaktivitas.", "25:18", "W6NZfCO5eJo"),
            CourseVideo(4, "4. Responsive Web Design", "Membuat website yang responsif di berbagai perangkat.", "22:05", "srvUrASNj0s"),
            CourseVideo(5, "5. Node.js & Express Setup", "Setup backend dengan Node.js dan Express.", "30:42", "f2EqECiBClg")
        ),
        category = "Web Development"
    ),
    2 to CourseDetails(
        id = 2,
        title = "UI/UX Design Fundamentals",
        description = "Pelajari prinsip-prinsip dasar desain antarmuka (UI) dan pengalaman pengguna (UX). Dari riset pengguna hingga prototyping, kursus ini mencakup semua yang Anda butuhkan untuk memulai.",
        price = "Rp. 45,000",
        rating = "4.8",
        students = "789 Students",
        level = "Beginner",
        benefits = listOf(
            "Memahami proses desain dari awal hingga akhir",
            "Membuat wireframe dan prototipe interaktif",
            "Melakukan riset pengguna dan usability testing"
        ),
        tools = "Figma, Sketch, Adobe XD",
        videos = listOf(
            CourseVideo(1, "1. Introduction to UI/UX", "Apa itu UI/UX dan mengapa itu penting.", "10:15", "c9F5kLFlc_8"),
            CourseVideo(2, "2. User Research", "Metode untuk memahami kebutuhan pengguna.", "20:30", "J3v3A3Qo2i4"),
            CourseVideo(3, "3. Wireframing & Prototyping", "Dari ide ke prototipe menggunakan Figma.", "35:50", "5b0t_33yCq4")
        ),
        category = "UI/UX Design"
    ),
    3 to CourseDetails(
        id = 3,
        title = "3D Blender Beginner",
        description = "Pelajari dasar-dasar 3D modeling dan rendering menggunakan Blender, software 3D gratis dan open-source yang sangat powerful.",
        price = "Rp. 25,000",
        rating = "4.5",
        students = "212 Students",
        level = "Beginner",
        benefits = listOf(
            "Membuat model 3D sederhana",
            "Memahami lighting dan texturing",
            "Mampu melakukan rendering gambar dari model 3D"
        ),
        tools = "Blender",
        videos = listOf(
            CourseVideo(1, "1. Pengenalan Interface Blender", "Mengenal tampilan dan navigasi dasar di Blender.", "11:20", "lLK_p24L_cI"),
            CourseVideo(2, "2. Basic Modeling: Membuat Meja", "Latihan membuat objek sederhana dari bentuk dasar.", "22:45", "TPrnSACiTJ4"),
            CourseVideo(3, "3. Material dan Texturing Dasar", "Memberi warna dan tekstur pada model 3D.", "18:10", "ZtG4gE4w3yY")
        ),
        category = "3D Design"
    ),
    4 to CourseDetails(
        id = 4,
        title = "Advanced 3D Sculpting",
        description = "Tingkatkan skill sculpting Anda ke level profesional. Pelajari anatomi, detail karakter, dan teknik texturing canggih di Blender.",
        price = "Rp. 75,000",
        rating = "4.9",
        students = "150 Students",
        level = "Advanced",
        benefits = listOf(
            "Membuat model karakter 3D yang realistis",
            "Menguasai teknik sculpting dan retopology",
            "Memahami alur kerja produksi aset game/film"
        ),
        tools = "Blender, ZBrush",
        videos = listOf(
            CourseVideo(1, "1. Advanced Sculpting Interface", "Navigasi dan setup untuk sculpting profesional.", "14:50", "o27i_cb9_hE"),
            CourseVideo(2, "2. Character Anatomy Study", "Studi anatomi untuk karakter manusia.", "28:15", "j14c2-T9M4Q"),
            CourseVideo(3, "3. Retopology for Animation", "Teknik retopology untuk model yang siap dianimasikan.", "25:30", "LMP-v34sD6E")
        ),
        category = "3D Design"
    ),
    5 to CourseDetails(
        id = 5,
        title = "Art of Sketching",
        description = "Dari goresan pertama hingga karya seni yang utuh. Kursus ini akan memandu Anda memahami dasar-dasar sketsa, proporsi, bayangan, dan komposisi.",
        price = "Rp. 20,000",
        rating = "4.7",
        students = "500 Students",
        level = "Beginner",
        benefits = listOf(
            "Menggambar objek dari observasi",
            "Memahami perspektif dan proporsi",
            "Menciptakan komposisi gambar yang menarik"
        ),
        tools = "Pensil, Kertas, Digital Tablet (Opsional)",
        videos = listOf(
            CourseVideo(1, "1. Sketching Fundamentals", "Pengenalan alat dan teknik dasar.", "12:00", "22-nZ3f00T8"),
            CourseVideo(2, "2. How to Hold a Pencil", "Cara memegang pensil untuk berbagai efek.", "8:30", "3uEtd78qM2E"),
            CourseVideo(3, "3. Perspective Drawing", "Menggambar objek 3D di atas kertas 2D.", "15:45", "v33A71s3aVA")
        ),
        category = "Traditional Art"
    ),
    6 to CourseDetails(
        id = 6,
        title = "Graphic Design Advanced",
        description = "Fokus pada teori warna, tipografi, dan branding. Pelajari cara menciptakan identitas visual yang kuat dan komunikasi yang efektif melalui desain.",
        price = "Rp. 60,000",
        rating = "4.6",
        students = "410 Students",
        level = "Intermediate",
        benefits = listOf(
            "Membangun brand identity dari nol",
            "Menguasai tipografi untuk web dan cetak",
            "Membuat desain yang komunikatif dan efektif"
        ),
        tools = "Adobe Illustrator, Adobe Photoshop, Adobe InDesign",
        videos = listOf(
            CourseVideo(1, "1. Advanced Graphic Design Theory", "Teori di balik desain yang hebat.", "17:40", "5a0-322pD0g"),
            CourseVideo(2, "2. Color Theory in Practice", "Aplikasi teori warna dalam proyek nyata.", "21:10", "YqQxW1_C3y4"),
            CourseVideo(3, "3. Advanced Typography", "Memilih dan memasangkan font secara profesional.", "19:00", "sByzHoiYFX0")
        ),
        category = "Graphic Design"
    )
)
