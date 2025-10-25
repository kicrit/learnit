package com.example.learnit.model

import com.example.learnit.R

data class ListTopMenu(
    val imgTopMenu: Int,
    val descTopMenu: String
)

val ListTopMenus = listOf(
    ListTopMenu(R.drawable.ic_launcher_foreground, "3D Design"),
    ListTopMenu(R.drawable.back, "Art & Humanities"),
    ListTopMenu(R.drawable.ic_launcher_foreground, "Graphic Design")
)