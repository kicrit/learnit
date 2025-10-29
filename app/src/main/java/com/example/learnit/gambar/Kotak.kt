package com.example.learnit.gambar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val Kotak: ImageVector
    get() {
        if (_Kotak != null) {
            return _Kotak!!
        }
        _Kotak = ImageVector.Builder(
            name = "Kotak",
            defaultWidth = 34.dp,
            defaultHeight = 36.dp,
            viewportWidth = 34f,
            viewportHeight = 36f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 3f
            ) {
                moveTo(14.483f, 2.152f)
                lineTo(4.152f, 7.887f)
                curveTo(3.346f, 8.337f, 2.675f, 8.994f, 2.209f, 9.79f)
                curveTo(1.742f, 10.587f, 1.498f, 11.494f, 1.5f, 12.417f)
                verticalLineTo(23.544f)
                curveTo(1.498f, 24.466f, 1.743f, 25.373f, 2.209f, 26.169f)
                curveTo(2.675f, 26.965f, 3.346f, 27.622f, 4.152f, 28.071f)
                lineTo(14.486f, 33.808f)
                curveTo(15.255f, 34.236f, 16.12f, 34.46f, 17f, 34.46f)
                curveTo(17.88f, 34.46f, 18.745f, 34.236f, 19.514f, 33.808f)
                lineTo(29.847f, 28.073f)
                curveTo(30.654f, 27.624f, 31.325f, 26.966f, 31.791f, 26.17f)
                curveTo(32.258f, 25.373f, 32.502f, 24.466f, 32.5f, 23.544f)
                verticalLineTo(12.417f)
                curveTo(32.502f, 11.494f, 32.257f, 10.587f, 31.791f, 9.791f)
                curveTo(31.324f, 8.995f, 30.653f, 8.338f, 29.847f, 7.889f)
                lineTo(19.514f, 2.152f)
                curveTo(18.745f, 1.725f, 17.88f, 1.5f, 17f, 1.5f)
                curveTo(16.12f, 1.5f, 15.255f, 1.725f, 14.486f, 2.152f)
                horizontalLineTo(14.483f)
                close()
            }
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 3f
            ) {
                moveTo(31.449f, 9.299f)
                lineTo(16.998f, 17.98f)
                moveTo(16.998f, 17.98f)
                lineTo(2.548f, 9.299f)
                moveTo(16.998f, 17.98f)
                verticalLineTo(34.443f)
            }
        }.build()

        return _Kotak!!
    }

@Suppress("ObjectPropertyName")
private var _Kotak: ImageVector? = null
