package com.example.learnit.course.course.model

data class ListCourse(
    val id : Int,
    val descCourse: String,
    val descCourse2: String,
    val progressCourse: String

)

val courseList = listOf(
    ListCourse(
        id = 1,
        descCourse = "Graphic Design",
        descCourse2 = "Graphic Design Advanced",
        progressCourse = "Progress 90% >"
    ),
    ListCourse(
        id = 2,
        descCourse = "sd",
        descCourse2 = "sd w",
        progressCourse = "progres 901%"
    ),
    ListCourse(
        id = 3,
        descCourse = "we",
        descCourse2 = "we lawswwwk",
        progressCourse = "progres 902%"
    ),
    ListCourse(
        id = 4,
        descCourse = "vsdv",
        descCourse2 = "sdv lawsk",
        progressCourse = "progres 903%"
    ),
    ListCourse(
        id = 5,
        descCourse = "123",
        descCourse2 = "sd v",
        progressCourse = "progres 904%"
    ),
)