package com.example.quiz_omgu_android_app.utils

import android.graphics.BlurMaskFilter
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawOutline
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Modifier.dropShadow(
    color: Color = Color.Black.copy(0.3f),
    blur: Dp = 4.dp,
    offsetX: Dp = 0.dp,
    offsetY: Dp = 4.dp,
    spread: Dp = 0.dp,
    shape: Shape = MaterialTheme.shapes.medium
): Modifier = this.drawBehind {
    val shadowSize = Size(size.width + spread.toPx(), size.height + spread.toPx())
    val shadowOutline = shape.createOutline(shadowSize, layoutDirection, this)

    val paint = Paint().apply {
        this.color = color
        asFrameworkPaint().maskFilter = BlurMaskFilter(blur.toPx(), BlurMaskFilter.Blur.NORMAL)
    }

    drawIntoCanvas { canvas ->
        canvas.save()
        canvas.translate(offsetX.toPx(), offsetY.toPx())
        canvas.drawOutline(shadowOutline, paint)
        canvas.restore()
    }
}