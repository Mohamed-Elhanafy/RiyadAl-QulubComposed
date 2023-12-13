package com.example.riyadal_qulub.ui.addingWirdScreen

import java.time.LocalDateTime

data class AddWirdViewState (
    var wirdName: String = "",
    val repeatedDays :List<String> = emptyList(),
    val startedDate:LocalDateTime = LocalDateTime.now(),
    val isMorningWird:Boolean = false,
    val isEveningWird:Boolean = false,
    val wirdNotificationTime:LocalDateTime = LocalDateTime.now(),

    )