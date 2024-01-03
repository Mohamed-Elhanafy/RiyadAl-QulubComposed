package com.example.riyadal_qulub.ui.components.calender

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily
import com.kizitonwose.calendar.compose.HorizontalCalendar
import com.kizitonwose.calendar.compose.rememberCalendarState
import com.kizitonwose.calendar.core.CalendarDay
import com.kizitonwose.calendar.core.DayPosition
import com.kizitonwose.calendar.core.daysOfWeek
import com.kizitonwose.calendar.core.firstDayOfWeekFromLocale
import java.time.DayOfWeek
import java.time.LocalDateTime
import java.time.YearMonth
import java.time.format.TextStyle
import java.util.Locale


@Composable
fun MonthCalenderItem(wird: Wird) {
    val daysOfWeek = remember { daysOfWeek(firstDayOfWeek = DayOfWeek.SUNDAY) }
    val currentMonth = remember { YearMonth.now() }
    val startMonth = remember { currentMonth.minusMonths(100) } // Adjust as needed
    val endMonth = remember { currentMonth.plusMonths(100) } // Adjust as needed
    val firstDayOfWeek = remember { firstDayOfWeekFromLocale() } // Available from the library
    val doneDays = wird.doneDays

    val state = rememberCalendarState(
        startMonth = startMonth,
        endMonth = endMonth,
        firstVisibleMonth = currentMonth,
        firstDayOfWeek = firstDayOfWeek
    )
    Box(modifier = Modifier.padding(16.dp)) {
        HorizontalCalendar(
            state = state,
            dayContent = { Day(it,doneDays) },
            monthHeader = {
                DaysOfWeekTitle(daysOfWeek = daysOfWeek) // Use the title as month header
            }
        )
    }
}

@Composable
fun DaysOfWeekTitle(daysOfWeek: List<DayOfWeek>) {
    Row(modifier = Modifier.fillMaxWidth()) {
        for (dayOfWeek in daysOfWeek) {
            Text(
                modifier = Modifier.weight(1f),
                textAlign = TextAlign.Center,
                text = dayOfWeek.getDisplayName(TextStyle.SHORT, Locale("ar")),
                fontFamily = rubikSansFamily,
                fontSize = 15.sp,
            )
        }
    }
}

@Composable
fun Day(day: CalendarDay, doneDays: List<LocalDateTime>) {
    val isDone = doneDays.any { it.toLocalDate() == day.date }

    Box(
        modifier = Modifier
            .aspectRatio(1f)
            .clickable { },
        contentAlignment = Alignment.Center
    ) {
        if (isDone) {
            Canvas(modifier = Modifier.size(36.dp)) {
                val radius = size.minDimension / 2 - 1.dp.toPx()
                drawCircle(
                    color = Primary,
                    center = center,
                    radius = radius,
                    style = Fill
                )
            }
        }
        Text(
            text = day.date.dayOfMonth.toString(),
            color = if  (isDone) {
                Color.White
            } else if(day.position == DayPosition.MonthDate)  {
                Color.Black
            } else {
                Color.LightGray
            }
        )
    }
}


/*
@Preview
@Composable
fun MainScreenPreview() {
    MonthCalenderItem()
}*/
