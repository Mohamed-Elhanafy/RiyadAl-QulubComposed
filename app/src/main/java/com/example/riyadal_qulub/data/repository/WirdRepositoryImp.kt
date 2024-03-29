package com.example.riyadal_qulub.data.repository

import com.example.riyadal_qulub.data.local.db.WirdDatabase
import com.example.riyadal_qulub.domain.model.WeekDays
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.domain.repository.WirdRepository
import java.time.LocalDateTime
import javax.inject.Inject

class WirdRepositoryImp @Inject constructor(
    private val db: WirdDatabase,

    ) : WirdRepository {
    private val dao = db.dao
    override suspend fun getAllWirds(): List<Wird> {
        return dao.getAll()
    }

    override suspend  fun insertWird(vararg wird: Wird) {
        dao.insertWird(*wird)
    }

    override suspend  fun deleteWird(wird: Wird) {
        dao.delete(wird)
    }

    override suspend  fun updateIsDone(wirdId: Int, isDone: Boolean) {
        dao.updateIsDone(wirdId, isDone)
    }


    override suspend  fun updateWirdDays(wirdId: Int, doneDates: List<LocalDateTime>) {
        dao.updateWirdDays(wirdId, doneDates)

    }

    override suspend fun updateDoneDates(wirdId: Int, doneDates: List<LocalDateTime>) {
        dao.updateDoneDates(wirdId, doneDates)
    }

    override suspend fun getWirdById(wirdId: Int): Wird {
        return dao.getWirdById(wirdId)
    }

    override suspend fun getWirdByWirdDays(wirdDays: List<WeekDays>): List<Wird> {
        return dao.getAll().filter { it.wirdDays.intersect(wirdDays).isNotEmpty() }
    }

    override suspend fun deleteAllWirds() {
        dao.deleteAllWirds()
    }
}