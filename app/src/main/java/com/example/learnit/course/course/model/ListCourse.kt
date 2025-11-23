package com.example.learnit.course.course.model

data class ListCourse(
    val id : Int,
    val descCourse: String,
    val descCourse2: String,
    val progressCourse: String,
    val category: String // Added category

)

val courseList = listOf(
    ListCourse(
        id = 1,
        descCourse = "Web Development",
        descCourse2 = "Web Programming",
        progressCourse = "0%",
        category = "Web Development"
    ),
    ListCourse(
        id = 2,
        descCourse = "UI/UX Design",
        descCourse2 = "UI/UX Design Fundamentals",
        progressCourse = "0%",
        category = "UI/UX Design"
    ),
    ListCourse(
        id = 3,
        descCourse = "3D Design",
        descCourse2 = "3D Blender Beginner",
        progressCourse = "0%",
        category = "3D Design"
    ),
    ListCourse(
        id = 4,
        descCourse = "3D Design",
        descCourse2 = "Advanced 3D Sculpting",
        progressCourse = "0%",
        category = "3D Design"
    ),
    ListCourse(
        id = 5,
        descCourse = "Traditional Art",
        descCourse2 = "Art of Sketching",
        progressCourse = "0%",
        category = "Traditional Art"
    ),
    ListCourse(
        id = 6,
        descCourse = "Graphic Design",
        descCourse2 = "Graphic Design Advanced",
        progressCourse = "0%",
        category = "Graphic Design"
    )
)
