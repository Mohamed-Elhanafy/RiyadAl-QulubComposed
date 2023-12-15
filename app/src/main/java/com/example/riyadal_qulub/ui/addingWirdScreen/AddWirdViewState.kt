package com.example.riyadal_qulub.ui.addingWirdScreen

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import java.time.LocalDateTime

data class AddWirdViewState (
    var wirdName: String = "",
    val repeatedDays :List<LocalDateTime> = emptyList(),
    val startedDate:LocalDateTime = LocalDateTime.now(),
    val isMorningWird:Boolean = false,
    val isEveningWird:Boolean = false,
    val wirdNotificationTime:LocalDateTime = LocalDateTime.now(),
    val daysCheckedState: MutableState<List<LocalDateTime>> = mutableStateOf(emptyList()),

    )