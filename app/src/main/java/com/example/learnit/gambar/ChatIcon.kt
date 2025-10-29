package com.example.learnit.gambar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ChatIcon: ImageVector
    get() {
        if (_ChatIcon != null) {
            return _ChatIcon!!
        }
        _ChatIcon = ImageVector.Builder(
            name = "ChatIcon",
            defaultWidth = 20.dp,
            defaultHeight = 20.dp,
            viewportWidth = 20f,
            viewportHeight = 20f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF202244)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(5.594f, 8.809f)
                curveTo(6.25f, 8.809f, 6.781f, 9.344f, 6.781f, 10f)
                curveTo(6.781f, 10.656f, 6.25f, 11.187f, 5.594f, 11.187f)
                curveTo(4.938f, 11.187f, 4.402f, 10.656f, 4.402f, 10f)
                curveTo(4.402f, 9.344f, 4.938f, 8.809f, 5.594f, 8.809f)
                close()
                moveTo(14.398f, 8.809f)
                curveTo(15.054f, 8.809f, 15.586f, 9.344f, 15.586f, 10f)
                curveTo(15.586f, 10.652f, 15.054f, 11.187f, 14.398f, 11.187f)
                curveTo(13.742f, 11.187f, 13.211f, 10.652f, 13.211f, 10f)
                curveTo(13.211f, 9.344f, 13.742f, 8.809f, 14.398f, 8.809f)
                close()
                moveTo(9.996f, 8.809f)
                curveTo(10.652f, 8.809f, 11.183f, 9.344f, 11.183f, 10f)
                curveTo(11.183f, 10.652f, 10.652f, 11.187f, 9.996f, 11.187f)
                curveTo(9.34f, 11.187f, 8.809f, 10.652f, 8.809f, 10f)
                curveTo(8.809f, 9.344f, 9.34f, 8.809f, 9.996f, 8.809f)
                close()
                moveTo(10.008f, 0f)
                curveTo(11.625f, 0f, 13.234f, 0.398f, 14.668f, 1.152f)
                curveTo(19.543f, 3.727f, 21.418f, 9.785f, 18.847f, 14.664f)
                curveTo(17.094f, 17.988f, 13.64f, 20f, 9.996f, 20f)
                curveTo(9.281f, 20f, 8.562f, 19.922f, 7.848f, 19.766f)
                curveTo(7.445f, 19.676f, 7.191f, 19.273f, 7.277f, 18.871f)
                curveTo(7.367f, 18.469f, 7.766f, 18.215f, 8.172f, 18.301f)
                curveTo(11.898f, 19.129f, 15.742f, 17.344f, 17.523f, 13.965f)
                curveTo(19.707f, 9.816f, 18.113f, 4.664f, 13.969f, 2.48f)
                curveTo(12.754f, 1.836f, 11.383f, 1.496f, 10.008f, 1.496f)
                curveTo(5.309f, 1.496f, 1.496f, 5.312f, 1.496f, 10f)
                curveTo(1.496f, 11.363f, 1.828f, 12.723f, 2.461f, 13.93f)
                lineTo(2.652f, 14.305f)
                curveTo(2.887f, 14.746f, 2.938f, 15.293f, 2.785f, 15.789f)
                curveTo(2.573f, 16.344f, 2.402f, 16.883f, 2.258f, 17.422f)
                curveTo(2.816f, 17.254f, 3.504f, 17.004f, 4f, 16.824f)
                lineTo(4.203f, 16.75f)
                curveTo(4.59f, 16.605f, 5.02f, 16.809f, 5.16f, 17.199f)
                curveTo(5.301f, 17.586f, 5.102f, 18.016f, 4.711f, 18.156f)
                lineTo(4.512f, 18.23f)
                curveTo(3.77f, 18.5f, 2.754f, 18.867f, 2.07f, 19.019f)
                curveTo(2.012f, 19.035f, 1.948f, 19.043f, 1.891f, 19.039f)
                curveTo(1.434f, 19.039f, 1.152f, 18.855f, 1f, 18.695f)
                curveTo(0.762f, 18.457f, 0.648f, 18.121f, 0.664f, 17.695f)
                curveTo(0.664f, 17.644f, 0.672f, 17.598f, 0.68f, 17.547f)
                curveTo(0.859f, 16.789f, 1.09f, 16.035f, 1.371f, 15.301f)
                curveTo(1.391f, 15.23f, 1.379f, 15.101f, 1.32f, 14.992f)
                lineTo(1.129f, 14.617f)
                curveTo(0.391f, 13.203f, 0f, 11.601f, 0f, 9.996f)
                curveTo(0f, 4.484f, 4.484f, 0f, 9.996f, 0f)
                horizontalLineTo(10.008f)
                close()
            }
        }.build()

        return _ChatIcon!!
    }

@Suppress("ObjectPropertyName")
private var _ChatIcon: ImageVector? = null
