package com.example.riyadal_qulub.ui.addingWirdScreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.domain.repository.WirdRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDateTime
import javax.inject.Inject


@HiltViewModel
class AddViewModel @Inject constructor(
    val repository: WirdRepository
) :ViewModel(){

    private val _state =MutableStateFlow(AddWirdViewState())
    val state = _state


    fun updateWirdName(newName: String) {
        state.value = state.value.copy(wirdName = newName)
    }

    fun updateIsMorningWird(isMorningWird: Boolean) {
        state.value = state.value.copy(isMorningWird = isMorningWird)
    }

    fun updateIsEveningWird(isEveningWird: Boolean) {
        state.value = state.value.copy(isEveningWird = isEveningWird)
    }




    fun addWird(){
     viewModelScope.launch(Dispatchers.IO) {
         repository.insertWird(
            Wird(
                name = state.value.wirdName,
                isMorningWird = state.value.isMorningWird,
                isEveningWird = state.value.isEveningWird,
                wirdDays = state.value.daysCheckedState.value,
                startDate = state.value.startedDate,
                doneDays = listOf() // Provide an empty list for doneDays
            )
         )
     }
    }
}