package com.example.learnit.gambar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ProfileIcon: ImageVector
    get() {
        if (_ProfileIcon != null) {
            return _ProfileIcon!!
        }
        _ProfileIcon = ImageVector.Builder(
            name = "ProfileIcon",
            defaultWidth = 16.dp,
            defaultHeight = 20.dp,
            viewportWidth = 16f,
            viewportHeight = 20f
        ).apply {
            path(
                fill = SolidColor(Color(0xFF202244)),
                pathFillType = PathFillType.EvenOdd
            ) {
                moveTo(7.992f, 1.531f)
                curveTo(6.98f, 1.527f, 6.012f, 1.93f, 5.297f, 2.648f)
                curveTo(4.582f, 3.367f, 4.18f, 4.344f, 4.18f, 5.359f)
                curveTo(4.176f, 6.91f, 5.102f, 8.312f, 6.527f, 8.91f)
                curveTo(7.949f, 9.504f, 9.59f, 9.18f, 10.683f, 8.082f)
                curveTo(11.773f, 6.988f, 12.101f, 5.336f, 11.512f, 3.902f)
                curveTo(10.922f, 2.469f, 9.531f, 1.531f, 7.992f, 1.531f)
                close()
                moveTo(5.965f, 0.406f)
                curveTo(7.953f, -0.422f, 10.246f, 0.039f, 11.765f, 1.574f)
                curveTo(13.289f, 3.105f, 13.742f, 5.414f, 12.914f, 7.414f)
                curveTo(12.09f, 9.418f, 10.144f, 10.723f, 7.992f, 10.719f)
                curveTo(5.055f, 10.711f, 2.676f, 8.316f, 2.676f, 5.359f)
                lineTo(2.684f, 5.129f)
                curveTo(2.77f, 3.052f, 4.047f, 1.207f, 5.965f, 0.406f)
                close()
                moveTo(5.883f, 12.766f)
                curveTo(7.32f, 12.645f, 8.766f, 12.645f, 10.203f, 12.766f)
                curveTo(10.988f, 12.821f, 11.769f, 12.934f, 12.535f, 13.11f)
                curveTo(14.195f, 13.446f, 15.281f, 14.106f, 15.734f, 15.074f)
                curveTo(16.097f, 15.875f, 16.086f, 16.801f, 15.707f, 17.598f)
                curveTo(15.246f, 18.567f, 14.16f, 19.227f, 12.472f, 19.571f)
                curveTo(11.711f, 19.742f, 10.933f, 19.852f, 10.148f, 19.903f)
                curveTo(9.285f, 20f, 8.551f, 20f, 7.867f, 20f)
                horizontalLineTo(7.598f)
                curveTo(7.211f, 19.957f, 6.918f, 19.629f, 6.918f, 19.239f)
                curveTo(6.918f, 18.848f, 7.211f, 18.52f, 7.598f, 18.477f)
                horizontalLineTo(8.195f)
                curveTo(8.793f, 18.469f, 9.398f, 18.442f, 10f, 18.391f)
                curveTo(10.711f, 18.344f, 11.418f, 18.242f, 12.117f, 18.09f)
                curveTo(13.312f, 17.828f, 14.066f, 17.449f, 14.301f, 16.946f)
                curveTo(14.484f, 16.563f, 14.484f, 16.117f, 14.301f, 15.735f)
                curveTo(14.066f, 15.223f, 13.312f, 14.828f, 12.14f, 14.59f)
                curveTo(11.433f, 14.43f, 10.715f, 14.324f, 9.992f, 14.281f)
                curveTo(8.641f, 14.156f, 7.281f, 14.156f, 5.93f, 14.281f)
                curveTo(5.215f, 14.328f, 4.504f, 14.426f, 3.805f, 14.578f)
                curveTo(2.605f, 14.844f, 1.863f, 15.223f, 1.621f, 15.723f)
                curveTo(1.531f, 15.914f, 1.488f, 16.121f, 1.488f, 16.332f)
                curveTo(1.488f, 16.543f, 1.531f, 16.754f, 1.621f, 16.946f)
                curveTo(2.035f, 17.52f, 2.668f, 17.891f, 3.367f, 17.977f)
                lineTo(3.469f, 18.004f)
                curveTo(3.699f, 18.082f, 3.879f, 18.27f, 3.949f, 18.512f)
                curveTo(4.031f, 18.781f, 3.953f, 19.078f, 3.75f, 19.278f)
                curveTo(3.547f, 19.477f, 3.25f, 19.543f, 2.984f, 19.453f)
                curveTo(1.855f, 19.27f, 0.867f, 18.594f, 0.281f, 17.606f)
                curveTo(-0.094f, 16.809f, -0.094f, 15.879f, 0.281f, 15.082f)
                curveTo(0.746f, 14.086f, 1.828f, 13.446f, 3.5f, 13.102f)
                curveTo(4.285f, 12.93f, 5.082f, 12.821f, 5.883f, 12.766f)
                close()
            }
        }.build()

        return _ProfileIcon!!
    }

@Suppress("ObjectPropertyName")
private var _ProfileIcon: ImageVector? = null
