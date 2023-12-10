package com.example.riyadal_qulub.util

sealed class WirdStatus {
    data object Done : WirdStatus()

    data object NotDone : WirdStatus()

    data object IsToday : WirdStatus()
}