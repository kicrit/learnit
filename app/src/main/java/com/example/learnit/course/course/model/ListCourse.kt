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
        descCourse = "Graphic Design",
        descCourse2 = "Graphic Design Advanced",
        progressCourse = "Beginner",
        category = "Graphic Design"
    ),
    ListCourse(
        id = 2,
        descCourse = "3D Design",
        descCourse2 = "3D Blender Beginner",
        progressCourse = "Beginner",
        category = "3D Design"
    ),
    ListCourse(
        id = 3,
        descCourse = "Art & Humanities",
        descCourse2 = "The Art of Sketching",
        progressCourse = "Beginner",
        category = "Art & Humanities"
    ),
    ListCourse(
        id = 4,
        descCourse = "Graphic Design",
        descCourse2 = "UI/UX with Figma",
        progressCourse = "Intermediate",
        category = "Graphic Design"
    ),
    ListCourse(
        id = 5,
        descCourse = "3D Design",
        descCourse2 = "Advanced 3D Sculpting",
        progressCourse = "Advanced",
        category = "3D Design"
    ),
)