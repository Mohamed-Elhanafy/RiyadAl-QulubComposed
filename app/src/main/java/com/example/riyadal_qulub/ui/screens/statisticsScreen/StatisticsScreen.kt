package com.example.riyadal_qulub.ui.screens.statisticsScreen

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.riyadal_qulub.ui.components.WeeklyChart
import com.example.riyadal_qulub.ui.components.WeeklyProgress

private const val TAG = "StatisticsScreen"

@Composable
fun StatisticsScreen(
    padding: PaddingValues,
    viewModel: StatisticsViewModel = hiltViewModel(),
    navController: NavController
) {

    val state by viewModel.state.collectAsState(
        initial = StatisticsViewState(
            listOf(
                0f,
                0f,
                0f,
                0f,
                0f,
                0f,
                0f
            )
        )
    )
    Log.d(TAG, "Week Percentage: ${state.weekPercentage}")
    if (state.weekPercentage != listOf(0f, 0f, 0f, 0f, 0f, 0f, 0f)) {
        Column(modifier = Modifier
            .padding(padding)
            .padding(16.dp)
            .fillMaxSize()) {
            WeeklyProgress(
                weekPrev = state.weekPercentage
            )
            Spacer(modifier = Modifier.padding(16.dp))
            WeeklyChart(
                state.weekPercentage[0],
                state.weekPercentage[1],
                state.weekPercentage[2],
                state.weekPercentage[3],
                state.weekPercentage[4],
                state.weekPercentage[5],
                state.weekPercentage[6]
            )
        }
    }


}