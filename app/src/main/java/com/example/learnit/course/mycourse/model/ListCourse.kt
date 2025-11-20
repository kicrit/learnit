package com.example.learnit.course.mycourse.model

data class ListCourse(
    val descCourse: String,
    val descCourse2: String,
    val progressCourse: String

)

val courseList = listOf(
    ListCourse(
        descCourse = "Graphic Design",
        descCourse2 = "Graphic Design Advanced",
        progressCourse = "Progress 90% >"
    ),
    ListCourse(
        descCourse = "sd",
        descCourse2 = "sd w",
        progressCourse = "progres 901%"
    ),
    ListCourse(
        descCourse = "we",
        descCourse2 = "we lawswwwk",
        progressCourse = "progres 902%"
    ),
    ListCourse(
        descCourse = "vsdv",
        descCourse2 = "sdv lawsk",
        progressCourse = "progres 903%"
    ),
    ListCourse(
        descCourse = "123",
        descCourse2 = "sd v",
        progressCourse = "progres 904%"
    ),
)