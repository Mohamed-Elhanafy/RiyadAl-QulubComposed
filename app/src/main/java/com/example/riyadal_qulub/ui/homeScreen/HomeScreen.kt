package com.example.riyadal_qulub.ui.homeScreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.ui.components.WeeklyCalendarItem
import com.example.riyadal_qulub.ui.components.WirdItem
import com.example.riyadal_qulub.ui.navigation.Screen
import com.example.riyadal_qulub.ui.theme.Gold
import com.example.riyadal_qulub.ui.theme.LabelNight
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.Secondary
import com.example.riyadal_qulub.ui.theme.rubikSansFamily
import com.example.riyadal_qulub.util.convertDayOfWeekToWeekDays
import com.kizitonwose.calendar.compose.WeekCalendar
import com.kizitonwose.calendar.compose.weekcalendar.rememberWeekCalendarState
import java.time.LocalDate

private const val TAG = "HomeScreen"

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    navController: NavController
) {

    val state by viewModel.state.collectAsStateWithLifecycle()
    val wirdStatus = state.wirds.map { mutableStateOf(it) }

    val weekCalendarState = rememberWeekCalendarState(
        startDate = LocalDate.now(),
        endDate = LocalDate.now().plusDays(6)
    )


    //todo add loading state`

    Scaffold(

        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate(Screen.AddWirdScreen.route) },
                containerColor = Secondary
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add", tint = Color.White)
            }
        },
        floatingActionButtonPosition = FabPosition.End // This places the FAB at the bottom end of the screen
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            WeekCalendar(
                state = weekCalendarState,
                dayContent = {
                    WeeklyCalendarItem(it, onClick = { day ->
                        state.selectedDate.value = day.date
                    }, selectedDate = state.selectedDate.value)

                }
            )

            Spacer(modifier = Modifier.padding(8.dp))

            // Get the selected day of the week
            val selectedDayOfWeek = state.selectedDate.value.dayOfWeek
            val selectedWeekDay = convertDayOfWeekToWeekDays(selectedDayOfWeek)
            // Filter the wirds based on the selected day of the week
            val filteredWirds = state.wirds.filter { it.wirdDays.contains(selectedWeekDay) }

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                items(filteredWirds.size) { index ->
                    val wird = remember { mutableStateOf(filteredWirds[index]) }
                    WirdItem(
                        wird = wird,
                        onClick = { Log.i(TAG, it.name)})
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                }
            }


        }
    }


}

/*

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(navController = rememberNavController())
}*/
