package com.example.riyadal_qulub.util

import com.example.riyadal_qulub.domain.model.WeekDays
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