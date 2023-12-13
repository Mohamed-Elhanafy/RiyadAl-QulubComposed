package com.example.riyadal_qulub.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.ui.theme.LabelGrey
import com.example.riyadal_qulub.ui.theme.Secondary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily
import com.kizitonwose.calendar.compose.WeekCalendar
import com.kizitonwose.calendar.compose.weekcalendar.rememberWeekCalendarState
import com.kizitonwose.calendar.core.WeekDay
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

@Composable
fun WeeklyCalendarItem(day: WeekDay, onClick: (WeekDay) -> Unit, selectedDate: LocalDate) {
    val isSelected = day.date == selectedDate
    val dayOfWeekInArabic = day.date.dayOfWeek.getDisplayName(TextStyle.FULL, Locale("ar"))

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .size(48.dp)
            .clickable(
                onClick = {
                    onClick(day)
                }
            )
            .clip(RoundedCornerShape(14.dp))
            .background(
                color = if (isSelected) Secondary else Color.Transparent,
            ),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Text(
                text = dayOfWeekInArabic,
                fontFamily = rubikSansFamily,
                fontSize = 12.sp,
                fontWeight = if (isSelected) FontWeight.SemiBold else FontWeight.Normal,
                color = if (isSelected) Color.Black else LabelGrey
            )
            Text(
                text = day.date.dayOfMonth.toString(),
                fontFamily = rubikSansFamily,
                fontSize = 16.sp,
                color = if (isSelected) Color.Black else LabelGrey
            )
        }
    }
}


@Preview
@Composable
fun WeeklyCalenderPreview() {
    val state = rememberWeekCalendarState(
        startDate = LocalDate.now(),
        endDate = LocalDate.now().plusDays(6),

        )
    var selectedDate = remember { mutableStateOf(LocalDate.now()) }
    WeekCalendar(
        state = state,
        dayContent = {
            WeeklyCalendarItem(it, onClick = { day ->
                Log.i("TAG", "DayPreview:  ${day.date}")
                selectedDate.value = day.date
            }, selectedDate = selectedDate.value)
        }
    )

}