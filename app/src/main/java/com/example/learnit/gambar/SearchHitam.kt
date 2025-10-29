package com.example.learnit.gambar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val SearchHitam: ImageVector
    get() {
        if (_SearchHitam != null) {
            return _SearchHitam!!
        }
        _SearchHitam = ImageVector.Builder(
            name = "SearchHitam",
            defaultWidth = 21.dp,
            defaultHeight = 20.dp,
            viewportWidth = 21f,
            viewportHeight = 20f
        ).apply {
            path(
                fill = SolidColor(Color.Black),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(20.468f, 18.606f)
                lineTo(16.906f, 15.247f)
                lineTo(16.825f, 15.126f)
                curveTo(16.668f, 14.973f, 16.458f, 14.891f, 16.235f, 14.891f)
                curveTo(16.016f, 14.891f, 15.802f, 14.973f, 15.648f, 15.126f)
                curveTo(12.621f, 17.805f, 7.958f, 17.95f, 4.748f, 15.465f)
                curveTo(1.539f, 12.977f, 0.782f, 8.633f, 2.98f, 5.31f)
                curveTo(5.177f, 1.988f, 9.646f, 0.72f, 13.422f, 2.345f)
                curveTo(17.198f, 3.97f, 19.112f, 7.984f, 17.89f, 11.727f)
                curveTo(17.806f, 12.001f, 17.874f, 12.294f, 18.08f, 12.501f)
                curveTo(18.283f, 12.708f, 18.591f, 12.794f, 18.882f, 12.731f)
                curveTo(19.173f, 12.669f, 19.408f, 12.461f, 19.497f, 12.192f)
                curveTo(20.954f, 7.751f, 18.753f, 2.97f, 14.317f, 0.941f)
                curveTo(9.88f, -1.085f, 4.538f, 0.251f, 1.75f, 4.086f)
                curveTo(-1.039f, 7.922f, -0.44f, 13.102f, 3.162f, 16.282f)
                curveTo(6.76f, 19.458f, 12.281f, 19.676f, 16.15f, 16.794f)
                lineTo(19.303f, 19.77f)
                curveTo(19.627f, 20.079f, 20.152f, 20.079f, 20.481f, 19.77f)
                curveTo(20.804f, 19.461f, 20.804f, 18.961f, 20.481f, 18.649f)
                lineTo(20.468f, 18.606f)
                close()
            }
        }.build()

        return _SearchHitam!!
    }

@Suppress("ObjectPropertyName")
private var _SearchHitam: ImageVector? = null
