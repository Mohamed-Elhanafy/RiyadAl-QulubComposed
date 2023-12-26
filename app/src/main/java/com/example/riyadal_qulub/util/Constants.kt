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
val daysOfWeek = listOf(
    DayOfWeek.SATURDAY,
    DayOfWeek.SUNDAY,
    DayOfWeek.MONDAY,
    DayOfWeek.TUESDAY,
    DayOfWeek.WEDNESDAY,
    DayOfWeek.THURSDAY,
    DayOfWeek.FRIDAY
)