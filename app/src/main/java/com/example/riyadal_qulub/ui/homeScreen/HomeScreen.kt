package com.example.riyadal_qulub.ui.homeScreen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Divider
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.riyadal_qulub.ui.components.NavBar
import com.example.riyadal_qulub.ui.components.WeeklyCalendarItem
import com.example.riyadal_qulub.ui.components.WirdItem
import com.example.riyadal_qulub.ui.theme.Gold
import com.example.riyadal_qulub.ui.theme.LabelNight
import com.example.riyadal_qulub.ui.theme.Primary
import com.example.riyadal_qulub.ui.theme.Secondary
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
    val wirdStatus = state.wirds.map { mutableStateOf(it) }
    val weekCalendarState = rememberWeekCalendarState(
        startDate = LocalDate.now(),
        endDate = LocalDate.now().plusDays(6)
    )


    //todo add loading state`

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = { navController.navigate("add") },
                containerColor = Secondary
            ) {
                Icon(Icons.Filled.Add, contentDescription = "Add", tint = Primary)
            }
        }
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
                    //todo filter the wird list to make it only the day selected
                    WeeklyCalendarItem(it, onClick = { day ->
                        state.selectedDate.value = day.date
                    }, selectedDate = state.selectedDate.value)
                }
            )
            Spacer(modifier = Modifier.padding(16.dp))
            Text(
                text = if (state.wirds.isEmpty()) "" else "اوراد صباحية",
                fontFamily = rubikSansFamily,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Gold,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(8.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                items(state.wirds.size) { index ->
                    //todo filter the wird list to make it only the morning ones

                    WirdItem(wird = wirdStatus[index], onClick = { wird ->
                        //viewModel.onWirdClick(wird)
                    })
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                }
            }
            Divider(thickness = 1.dp, color = Color.LightGray, modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.padding(8.dp))

            Text(
                text = if (state.wirds.isEmpty()) "" else "اوراد مسائية",
                fontFamily = rubikSansFamily,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = LabelNight,
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.padding(8.dp))

            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
            ) {
                items(state.wirds.size) { index ->
                    //todo filter the wird list to make it only the night ones

                    WirdItem(wird = wirdStatus[index], onClick = { wird ->
                        //viewModel.onWirdClick(wird)
                    })
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
