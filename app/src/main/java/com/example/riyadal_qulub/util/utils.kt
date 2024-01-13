package com.example.riyadal_qulub.util

import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Canvas
import androidx.compose.ui.graphics.drawscope.DrawScope
import com.example.riyadal_qulub.domain.model.WeekDays
import com.github.tehras.charts.bar.renderer.xaxis.XAxisDrawer
import com.github.tehras.charts.bar.renderer.yaxis.YAxisDrawer
import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.util.Date

fun convertMillisToDate(millis: Long): LocalDateTime {
    return LocalDateTime.ofInstant(Date(millis).toInstant(), java.time.ZoneId.systemDefault())
}

fun formatLocalDateTime(localDateTime: LocalDateTime): String {
    // arabic date format
    val formatter = SimpleDateFormat("MM/dd")
    // localizing date to ar
    return formatter.format(Date.from(localDateTime.atZone(java.time.ZoneId.systemDefault()).toInstant()))
}

fun convertDayOfWeekToWeekDays(dayOfWeek: DayOfWeek): WeekDays {
    return when (dayOfWeek) {
        DayOfWeek.MONDAY -> WeekDays.MONDAY
        DayOfWeek.TUESDAY -> WeekDays.TUESDAY
        DayOfWeek.WEDNESDAY -> WeekDays.WEDNESDAY
        DayOfWeek.THURSDAY -> WeekDays.THURSDAY
        DayOfWeek.FRIDAY -> WeekDays.FRIDAY
        DayOfWeek.SATURDAY -> WeekDays.SATURDAY
        DayOfWeek.SUNDAY -> WeekDays.SUNDAY
    }
}


fun convertDayOfWeekToWeekDaysForStatistics(dayOfWeek: DayOfWeek): WeekDays {
    return when (dayOfWeek) {
        DayOfWeek.MONDAY -> WeekDays.MONDAY
        DayOfWeek.TUESDAY -> WeekDays.TUESDAY
        DayOfWeek.WEDNESDAY -> WeekDays.WEDNESDAY
        DayOfWeek.THURSDAY -> WeekDays.THURSDAY
        DayOfWeek.FRIDAY -> WeekDays.FRIDAY
        DayOfWeek.SATURDAY -> WeekDays.SATURDAY
        DayOfWeek.SUNDAY -> WeekDays.SUNDAY
    }
}

fun simplifyNumber(value: Float): String {
    return when {
        value >= 1000 && value < 1_000_000 -> DecimalFormat("0.#K").format(value / 1000)
        value >= 1_000_000 -> DecimalFormat("0.#M").format(value / 1_000_000)
        else -> DecimalFormat("0.#").format(value)
    }
}

class MyYAxisDrawer : YAxisDrawer {
    override fun drawAxisLabels(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect,
        minValue: Float,
        maxValue: Float
    ) {
        // Do nothing
    }

    override fun drawAxisLine(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect
    ) {
        // Do nothing
    }
}
class NoOpXAxisDrawer : XAxisDrawer {
    override fun drawAxisLine(
        drawScope: DrawScope,
        canvas: Canvas,
        drawableArea: Rect
    ) {
        // Do nothing
    }

    override fun requiredHeight(drawScope: DrawScope): Float {
        return 0f
    }
}