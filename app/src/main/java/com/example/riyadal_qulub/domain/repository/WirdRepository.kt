package com.example.riyadal_qulub.domain.repository

import com.example.riyadal_qulub.domain.model.Wird
import java.time.LocalDateTime

interface WirdRepository {
    suspend fun getAllWirds(): List<Wird>

    suspend  fun insertWird(vararg wird: Wird)

    suspend fun deleteWird(wird: Wird)

    suspend fun updateIsDone(wirdId: Int, isDone: Boolean)

    suspend fun updateDoneDates(wirdId: Int, doneDates: List<LocalDateTime>)

}