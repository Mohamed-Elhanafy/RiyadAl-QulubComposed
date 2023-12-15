package com.example.riyadal_qulub.ui.homeScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.riyadal_qulub.domain.model.Wird
import java.time.LocalDate

data class HomeViewState (
    val isLoading: Boolean = false,
    val isEmpty : Boolean = false,
    val wirds:List<Wird> = emptyList(),
    var selectedDate: MutableState<LocalDate> = mutableStateOf(LocalDate.now()),
)