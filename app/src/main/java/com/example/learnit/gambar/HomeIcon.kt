package com.example.learnit.gambar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val HomeIcon: ImageVector
    get() {
        if (_HomeIcon != null) {
            return _HomeIcon!!
        }
        _HomeIcon = ImageVector.Builder(
            name = "HomeIcon",
            defaultWidth = 19.dp,
            defaultHeight = 20.dp,
            viewportWidth = 19f,
            viewportHeight = 20f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF167F71)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7.922f, 18.258f)
                horizontalLineTo(3.922f)
                curveTo(2.625f, 18.254f, 1.574f, 17.207f, 1.566f, 15.91f)
                verticalLineTo(7.953f)
                curveTo(1.566f, 7.519f, 1.762f, 7.109f, 2.094f, 6.832f)
                lineTo(2.801f, 6.308f)
                curveTo(3.059f, 6.035f, 3.082f, 5.617f, 2.863f, 5.312f)
                curveTo(2.641f, 5.008f, 2.234f, 4.906f, 1.895f, 5.066f)
                lineTo(1.176f, 5.605f)
                curveTo(0.445f, 6.168f, 0.016f, 7.031f, 0f, 7.953f)
                verticalLineTo(15.918f)
                curveTo(0.004f, 18.082f, 1.758f, 19.836f, 3.922f, 19.84f)
                horizontalLineTo(7.922f)
                curveTo(8.355f, 19.84f, 8.703f, 19.488f, 8.703f, 19.059f)
                curveTo(8.703f, 18.625f, 8.355f, 18.274f, 7.922f, 18.274f)
                verticalLineTo(18.258f)
                close()
            }
            path(
                fill = SolidColor(Color(0xFF167F71)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(18.793f, 7.934f)
                curveTo(18.781f, 7.023f, 18.363f, 6.16f, 17.652f, 5.586f)
                lineTo(11.645f, 0.797f)
                curveTo(10.324f, -0.266f, 8.441f, -0.266f, 7.121f, 0.797f)
                lineTo(5.219f, 2.18f)
                curveTo(4.859f, 2.437f, 4.777f, 2.934f, 5.035f, 3.293f)
                curveTo(5.293f, 3.648f, 5.789f, 3.73f, 6.148f, 3.473f)
                lineTo(8.078f, 2.031f)
                curveTo(8.836f, 1.406f, 9.93f, 1.406f, 10.688f, 2.031f)
                lineTo(16.695f, 6.82f)
                curveTo(17.043f, 7.098f, 17.246f, 7.512f, 17.254f, 7.953f)
                verticalLineTo(15.918f)
                curveTo(17.254f, 17.215f, 16.199f, 18.266f, 14.906f, 18.266f)
                horizontalLineTo(13.121f)
                curveTo(12.938f, 18.266f, 12.793f, 18.117f, 12.793f, 17.934f)
                verticalLineTo(14.344f)
                curveTo(12.793f, 13.199f, 11.867f, 12.269f, 10.723f, 12.266f)
                horizontalLineTo(8.113f)
                curveTo(7.562f, 12.266f, 7.035f, 12.484f, 6.645f, 12.875f)
                curveTo(6.254f, 13.266f, 6.035f, 13.793f, 6.035f, 14.344f)
                verticalLineTo(15.719f)
                curveTo(6.035f, 16.148f, 6.387f, 16.5f, 6.816f, 16.5f)
                curveTo(7.25f, 16.5f, 7.602f, 16.148f, 7.602f, 15.719f)
                verticalLineTo(14.344f)
                curveTo(7.598f, 14.207f, 7.648f, 14.078f, 7.746f, 13.98f)
                curveTo(7.84f, 13.887f, 7.969f, 13.832f, 8.105f, 13.832f)
                horizontalLineTo(10.715f)
                curveTo(10.992f, 13.832f, 11.219f, 14.059f, 11.219f, 14.336f)
                verticalLineTo(17.934f)
                curveTo(11.223f, 18.984f, 12.074f, 19.832f, 13.121f, 19.832f)
                horizontalLineTo(14.859f)
                curveTo(17.027f, 19.832f, 18.781f, 18.074f, 18.781f, 15.91f)
                lineTo(18.793f, 7.934f)
                close()
            }
        }.build()

        return _HomeIcon!!
    }

@Suppress("ObjectPropertyName")
private var _HomeIcon: ImageVector? = null
