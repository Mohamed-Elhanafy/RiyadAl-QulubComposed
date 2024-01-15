package com.example.riyadal_qulub.notification.alarm
import java.time.LocalDateTime

data class AlarmItem(
    val time :LocalDateTime,
    val message :String,
)