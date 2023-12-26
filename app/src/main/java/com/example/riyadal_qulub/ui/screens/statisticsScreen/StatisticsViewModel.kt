package com.example.riyadal_qulub.ui.screens.statisticsScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riyadal_qulub.domain.model.WeekDays
import com.example.riyadal_qulub.domain.repository.WirdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "StatisticsViewModel"

@HiltViewModel
class StatisticsViewModel @Inject constructor(
    val repository: WirdRepository
) : ViewModel() {
    init {
        Log.i(TAG,listOf(WeekDays.WEDNESDAY).toString())
        getWirdsByWirdDays()
    }

    fun getWirdsByWirdDays() {

        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getWirdByWirdDays(listOf(WeekDays.WEDNESDAY))
            Log.i(TAG, "getWirdsByWirdDays: $response")
        }
    }
}