package com.example.riyadal_qulub.ui.screens.statisticsScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riyadal_qulub.domain.model.WeekDays
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.domain.repository.WirdRepository
import com.example.riyadal_qulub.util.convertDayOfWeekToWeekDays
import com.example.riyadal_qulub.util.daysOfWeek
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import javax.inject.Inject

private const val TAG = "StatisticsViewModel"

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val repository: WirdRepository
) : ViewModel() {
    init {
        getDailyWirdsAndCalculateDonePercentage()
    }

    // if the wird day is not selected but it's showing in the home screen
    fun getDailyWirdsAndCalculateDonePercentage() {
        viewModelScope.launch(Dispatchers.IO) {
            // Get the current date
            val currentDate = LocalDate.now()

            // Calculate the start and end of the week
            val startOfWeek = currentDate.with(TemporalAdjusters.previousOrSame(DayOfWeek.SATURDAY))
            val endOfWeek = currentDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY))

            // For each day of the week
            for (dayOfWeek in daysOfWeek) {
                // Convert the DayOfWeek to WeekDays
                val weekDay = convertDayOfWeekToWeekDays(dayOfWeek)

                // Get all the Wirds that should be done on that day
                val dailyWirds = repository.getWirdByWirdDays(listOf(weekDay))

                // Filter the Wirds that have been done on that day and within the current week
                val doneDailyWirds = dailyWirds.filter { wird ->
                    wird.doneDays.any { doneDate ->
                        val localDate = doneDate.toLocalDate()
                        localDate.dayOfWeek == dayOfWeek &&
                                !localDate.isBefore(startOfWeek) &&
                                !localDate.isAfter(endOfWeek)
                    }
                }

                // Calculate the percentage of done Wirds for that day
                val donePercentage = if (dailyWirds.isNotEmpty()) {
                    doneDailyWirds.size * 100 / dailyWirds.size
                } else {
                    0
                }

                Log.d(TAG, "Day: $dayOfWeek")
                //Log.d(TAG, "Daily Wirds: $dailyWirds")
                //Log.d(TAG, "Done Daily Wirds: $doneDailyWirds")
                Log.d(TAG, "Done Percentage: $donePercentage%")
            }
        }
    }

}

