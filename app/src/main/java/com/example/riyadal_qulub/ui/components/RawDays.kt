package com.example.riyadal_qulub.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun ClickableWeekDays(
    daysChecked: MutableState<List<LocalDateTime>>
) {
    val daysOfWeek = listOf(
        DayOfWeek.FRIDAY,
        DayOfWeek.THURSDAY,
        DayOfWeek.WEDNESDAY,
        DayOfWeek.TUESDAY,
        DayOfWeek.MONDAY,
        DayOfWeek.SUNDAY,
        DayOfWeek.SATURDAY
    )

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        for ((index, dayOfWeek) in daysOfWeek.withIndex()) {
            val dayOfWeekInArabic = dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ar"))
            ClickableDayCircle(
                day = dayOfWeekInArabic,
                clicked = daysChecked.value.contains(LocalDateTime.now().with(DayOfWeek.of(index + 1))),
                onCheckedChange = { isChecked ->
                    val date = LocalDateTime.now().with(DayOfWeek.of(index + 1))
                    if (isChecked) {
                        daysChecked.value = daysChecked.value + date
                    } else {
                        daysChecked.value = daysChecked.value - date
                    }
                }
            )
        }
    }


    Log.i("TAG", "ClickableWeekDays:    ${daysChecked.value} ")
}


/*

@Composable
@Preview
fun clickableWeekDaysPreview() {
    ClickableWeekDays()
}
*/
