package com.example.riyadal_qulub.ui.screens.homeScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riyadal_qulub.data.local.db.WirdDatabase
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.domain.repository.WirdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject

private const val TAG = "HomeViewModel"

@HiltViewModel
open class HomeViewModel @Inject constructor(
    private val repository: WirdRepository,
//    private val database : WirdDatabase
) : ViewModel() {
    private val _state = MutableStateFlow(HomeViewState())
    val state = _state.asStateFlow()

    fun updateDoneDays(wird: Wird, doneDate: LocalDateTime) {
        viewModelScope.launch(Dispatchers.IO) {
            val currentWird = repository.getWirdById(wird.id)
            val currentDoneDates = currentWird.doneDays

            // Check if the Wird is already done
            if (currentDoneDates.contains(doneDate)) {
                Log.i(TAG, "updateDoneDays: Wird is already done")
                //todo add functionality to remove the wird from the list of done wirds
                return@launch
            }

            val updatedDoneDates = currentDoneDates.toMutableList().apply { add(doneDate) }
            repository.updateDoneDates(wird.id, updatedDoneDates)
            val updatedWird = repository.getWirdById(wird.id)
            _state.value = state.value.copy(wirds = state.value.wirds.map {
                if (it.id == updatedWird.id) updatedWird else it
            })
        }
    }

    init {
        getWirds()
    }

    private fun getWirds() {
        viewModelScope.launch(Dispatchers.IO) {
            val wirds = repository.getAllWirds()
            _state.value = state.value.copy(wirds = wirds)
            Log.i(TAG, "getWirds: Done ")
        }
    }

}