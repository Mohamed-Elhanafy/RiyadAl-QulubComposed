package com.example.riyadal_qulub.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.time.DayOfWeek
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun ClickableWeekDays() {
    // Create a list of days of the week
    val daysOfWeek = listOf(
        DayOfWeek.FRIDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.MONDAY,
        DayOfWeek.SUNDAY,
        DayOfWeek.SATURDAY
    )

    // Create a row of ClickableDayCircle for each day of the week
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        for (dayOfWeek in daysOfWeek) {
            // Get the day of the week in Arabic
            val dayOfWeekInArabic = dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ar"))
            // Create a ClickableDayCircle for the day
            ClickableDayCircle(day = dayOfWeekInArabic)
        }
    }
}


@Composable
@Preview
fun clickableWeekDaysPreview() {
    ClickableWeekDays()
}
