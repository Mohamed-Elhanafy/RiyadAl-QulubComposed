package com.example.riyadal_qulub.domain.repository

import com.example.riyadal_qulub.domain.model.WeekDays
import com.example.riyadal_qulub.domain.model.Wird
import java.time.LocalDateTime

interface WirdRepository {
    suspend fun getAllWirds(): List<Wird>

    suspend  fun insertWird(vararg wird: Wird)

    suspend fun deleteWird(wird: Wird)

    suspend fun updateIsDone(wirdId: Int, isDone: Boolean)

    suspend fun updateWirdDays(wirdId: Int, doneDates: List<LocalDateTime>)

    suspend fun updateDoneDates(wirdId: Int, doneDates: List<LocalDateTime>)

    suspend fun getWirdById(wirdId: Int): Wird

    suspend fun getWirdByWirdDays(wirdDays: List<WeekDays>): List<Wird>

    suspend fun deleteAllWirds()
}