package com.example.learnit.gambar

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val OrangLagu: ImageVector
    get() {
        if (_OrangLagu != null) {
            return _OrangLagu!!
        }
        _OrangLagu = ImageVector.Builder(
            name = "OrangLagu",
            defaultWidth = 38.dp,
            defaultHeight = 35.dp,
            viewportWidth = 38f,
            viewportHeight = 35f
        ).apply {
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 3f
            ) {
                moveTo(17.056f, 13.167f)
                curveTo(20.277f, 13.167f, 22.889f, 10.555f, 22.889f, 7.333f)
                curveTo(22.889f, 4.112f, 20.277f, 1.5f, 17.056f, 1.5f)
                curveTo(13.834f, 1.5f, 11.222f, 4.112f, 11.222f, 7.333f)
                curveTo(11.222f, 10.555f, 13.834f, 13.167f, 17.056f, 13.167f)
                close()
            }
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 3f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(28.722f, 32.611f)
                curveTo(30.87f, 32.611f, 32.611f, 30.87f, 32.611f, 28.722f)
                curveTo(32.611f, 26.574f, 30.87f, 24.833f, 28.722f, 24.833f)
                curveTo(26.574f, 24.833f, 24.833f, 26.574f, 24.833f, 28.722f)
                curveTo(24.833f, 30.87f, 26.574f, 32.611f, 28.722f, 32.611f)
                close()
            }
            path(
                stroke = SolidColor(Color.Black),
                strokeLineWidth = 3f,
                strokeLineCap = StrokeCap.Round,
                strokeLineJoin = StrokeJoin.Round
            ) {
                moveTo(17.719f, 32.611f)
                horizontalLineTo(5.389f)
                curveTo(4.357f, 32.611f, 3.368f, 32.201f, 2.639f, 31.472f)
                curveTo(1.91f, 30.743f, 1.5f, 29.754f, 1.5f, 28.722f)
                curveTo(1.5f, 26.659f, 2.319f, 24.681f, 3.778f, 23.222f)
                curveTo(5.237f, 21.764f, 7.215f, 20.944f, 9.278f, 20.944f)
                horizontalLineTo(20.027f)
                moveTo(32.611f, 28.722f)
                verticalLineTo(15.111f)
                lineTo(36.5f, 19f)
            }
        }.build()

        return _OrangLagu!!
    }

@Suppress("ObjectPropertyName")
private var _OrangLagu: ImageVector? = null
