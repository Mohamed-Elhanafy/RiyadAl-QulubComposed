package com.example.riyadal_qulub.util

import com.example.riyadal_qulub.domain.model.WeekDays
import java.time.DayOfWeek

object DatabaseConstants {
    const val DATABASE_NAME = "wird_database"
}



// Map of WeekDays enum values to their names in Arabic
val daysOfWeekInArabic = mapOf(
    WeekDays.FRIDAY to "الجمعة",
    WeekDays.THURSDAY to "الخميس",
    WeekDays.WEDNESDAY to "الأربعاء",
    WeekDays.TUESDAY to "الثلاثاء",
    WeekDays.MONDAY to "الاثنين",
    WeekDays.SUNDAY to "الأحد",
    WeekDays.SATURDAY to "السبت"
)


// Helper function to convert DayOfWeek to WeekDays
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