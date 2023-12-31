package com.example.riyadal_qulub.ui.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import com.example.riyadal_qulub.domain.model.WeekDays
import com.example.riyadal_qulub.ui.components.calender.ClickableDayCircle
import com.example.riyadal_qulub.util.daysOfWeekInArabic

@Composable
fun ClickableWeekDays(
    daysChecked: MutableState<List<WeekDays>>
) {
    val daysOfWeek = WeekDays.values().toList()

    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
        for ((index, dayOfWeek) in daysOfWeek.withIndex()) {
            // Get the name in Arabic from the map
            val dayOfWeekInArabic = daysOfWeekInArabic[dayOfWeek]
            ClickableDayCircle(
                day = dayOfWeekInArabic!!,
                clicked = daysChecked.value.contains(dayOfWeek),
                onCheckedChange = { isChecked ->
                    if (isChecked) {
                        daysChecked.value = daysChecked.value + dayOfWeek
                    } else {
                        daysChecked.value = daysChecked.value - dayOfWeek
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
