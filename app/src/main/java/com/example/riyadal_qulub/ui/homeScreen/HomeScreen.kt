package com.example.riyadal_qulub.ui.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.riyadal_qulub.ui.components.WeeklyCalendarItem
import com.example.riyadal_qulub.ui.theme.Gold
import com.example.riyadal_qulub.ui.theme.rubikSansFamily
import com.kizitonwose.calendar.compose.WeekCalendar
import com.kizitonwose.calendar.compose.weekcalendar.rememberWeekCalendarState
import java.time.LocalDate

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val weekCalendarState = rememberWeekCalendarState(
        startDate = LocalDate.now(),
        endDate = LocalDate.now().plusDays(6)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        WeekCalendar(
            state = weekCalendarState,
            dayContent = {
                WeeklyCalendarItem(it, onClick = { day ->
                    state.selectedDate.value = day.date
                }, selectedDate = state.selectedDate.value)
            }
        )
        Spacer(modifier  =  Modifier.padding(32.dp))
        Text(
            text = "اوراد صباحية",
            fontFamily = rubikSansFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            color = Gold,
            textAlign = TextAlign.Right,
            modifier = Modifier.fillMaxWidth()
        )

    }
}

/*

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}*/
