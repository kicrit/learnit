package com.example.learnit.gambar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val CourseIcon: ImageVector
    get() {
        if (_CourseIcon != null) {
            return _CourseIcon!!
        }
        _CourseIcon = ImageVector.Builder(
            name = "CourseIcon",
            defaultWidth = 18.dp,
            defaultHeight = 20.dp,
            viewportWidth = 18f,
            viewportHeight = 20f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF202244)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(8.133f, 5.043f)
                curveTo(8.5f, 5.082f, 8.777f, 5.398f, 8.777f, 5.77f)
                curveTo(8.777f, 6.145f, 8.5f, 6.457f, 8.133f, 6.5f)
                horizontalLineTo(5.391f)
                curveTo(5.023f, 6.457f, 4.746f, 6.145f, 4.746f, 5.77f)
                curveTo(4.746f, 5.398f, 5.023f, 5.082f, 5.391f, 5.043f)
                horizontalLineTo(8.133f)
                close()
                moveTo(12.594f, 9.273f)
                curveTo(12.867f, 9.242f, 13.137f, 9.371f, 13.285f, 9.609f)
                curveTo(13.43f, 9.848f, 13.43f, 10.152f, 13.285f, 10.391f)
                curveTo(13.137f, 10.629f, 12.867f, 10.758f, 12.594f, 10.727f)
                horizontalLineTo(5.383f)
                curveTo(5.016f, 10.688f, 4.738f, 10.375f, 4.738f, 10f)
                curveTo(4.738f, 9.625f, 5.016f, 9.312f, 5.383f, 9.273f)
                horizontalLineTo(12.594f)
                close()
                moveTo(12.594f, 13.512f)
                curveTo(12.988f, 13.512f, 13.305f, 13.836f, 13.305f, 14.234f)
                curveTo(13.305f, 14.633f, 12.988f, 14.957f, 12.594f, 14.957f)
                horizontalLineTo(5.383f)
                curveTo(4.988f, 14.957f, 4.668f, 14.633f, 4.668f, 14.234f)
                curveTo(4.668f, 13.836f, 4.988f, 13.512f, 5.383f, 13.512f)
                horizontalLineTo(12.594f)
                close()
                moveTo(12.852f, 0f)
                curveTo(16.067f, 0f, 17.992f, 1.953f, 18f, 5.211f)
                verticalLineTo(14.789f)
                curveTo(18f, 18.047f, 16.086f, 20f, 12.863f, 20f)
                horizontalLineTo(10.004f)
                curveTo(9.641f, 19.961f, 9.363f, 19.645f, 9.363f, 19.273f)
                curveTo(9.363f, 18.898f, 9.641f, 18.586f, 10.004f, 18.543f)
                horizontalLineTo(12.852f)
                curveTo(15.309f, 18.543f, 16.547f, 17.281f, 16.547f, 14.789f)
                verticalLineTo(5.211f)
                curveTo(16.547f, 2.719f, 15.309f, 1.457f, 12.852f, 1.457f)
                horizontalLineTo(5.137f)
                curveTo(2.684f, 1.457f, 1.438f, 2.719f, 1.438f, 5.211f)
                verticalLineTo(14.789f)
                curveTo(1.438f, 17.281f, 2.684f, 18.543f, 5.137f, 18.543f)
                curveTo(5.504f, 18.586f, 5.781f, 18.898f, 5.781f, 19.273f)
                curveTo(5.781f, 19.645f, 5.504f, 19.961f, 5.137f, 20f)
                curveTo(1.926f, 20f, 0f, 18.047f, 0f, 14.789f)
                verticalLineTo(5.211f)
                curveTo(0f, 1.941f, 1.926f, 0f, 5.137f, 0f)
                horizontalLineTo(12.852f)
                close()
            }
        }.build()

        return _CourseIcon!!
    }

@Suppress("ObjectPropertyName")
private var _CourseIcon: ImageVector? = null
