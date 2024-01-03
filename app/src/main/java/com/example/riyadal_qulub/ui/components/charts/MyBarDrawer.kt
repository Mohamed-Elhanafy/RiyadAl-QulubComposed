package com.example.riyadal_qulub.ui.components.charts


import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.example.riyadal_qulub.ui.theme.Secondary
import com.github.tehras.charts.bar.BarChartData
import com.github.tehras.charts.bar.renderer.bar.BarDrawer

class MyBarDrawer(recurrence: Float = 24f) :
    BarDrawer {
    private val barPaint = Paint().apply {
        this.isAntiAlias = true

    }


    private val rightOffset = 24f

    override fun drawBar(
        drawScope: DrawScope,
        canvas: Canvas,
        barArea: Rect,
        bar: BarChartData.Bar
    ) {
        canvas.drawRoundRect(
            barArea.left,
            0f,
            barArea.right + rightOffset,
            barArea.bottom,
            16f,
            16f,
            barPaint.apply {
                color = Secondary
            },
        )
        canvas.drawRoundRect(
            barArea.left,
            barArea.top,
            barArea.right + rightOffset,
            barArea.bottom,
            16f,
            16f,
            barPaint.apply {
                color = bar.color
            },
        )
    }
}