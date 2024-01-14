package com.example.riyadal_qulub.ui.components.charts


import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.nativeCanvas
import com.example.riyadal_qulub.ui.theme.Secondary

import com.github.tehras.charts.piechart.utils.toLegacyInt


class MyLabelDrawer :
    com.github.tehras.charts.bar.renderer.label.LabelDrawer {
    private val leftOffset = 45f


    override fun drawLabel(
        drawScope: DrawScope,
        canvas: Canvas,
        label: String,
        barArea: Rect,
        xAxisArea: Rect
    ) {
         val paint = android.graphics.Paint().apply {
            this.textAlign = android.graphics.Paint.Align.CENTER
            this.color = Secondary.toLegacyInt()
            this.textSize = 24f
        }

        canvas.nativeCanvas.drawText(
            label,
            barArea.left + leftOffset,
            barArea.top + 38f,
            paint
        )
    }
}