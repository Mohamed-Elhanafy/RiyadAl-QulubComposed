package com.example.riyadal_qulub.ui.screens.statisticsScreen

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.riyadal_qulub.ui.components.WeeklyProgress
import com.example.riyadal_qulub.ui.screens.wirdScreen.WirdViewModel

private const val TAG = "StatisticsScreen"

@Composable
fun StatisticsScreen(
    viewModel: StatisticsViewModel = hiltViewModel(),
    navController: NavController
) {
    WeeklyProgress(weekPrev = listOf(1f, 2f, 3f, 4f, 5f, 6f, 7f))
}