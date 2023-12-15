package com.example.riyadal_qulub.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.riyadal_qulub.domain.model.Wird
import java.time.LocalDateTime

@Dao
interface WirdDao {
    @Query("SELECT * FROM wirds")
    fun getAll(): List<Wird>

    @Insert
    fun insertWird(vararg wird: Wird)

    @Delete
    fun delete(wird: Wird)

/*    @Query("UPDATE wirds SET doneDays = :doneDays WHERE id = :wirdId")
    fun updateDoneDays(wirdId: Int, doneDays: List<LocalDateTime>)*/

    @Query("UPDATE wirds SET isDone = :isDone WHERE id = :wirdId")
    fun updateIsDone(wirdId: Int, isDone: Boolean)

    //add date to doneDates
/*    @Query("UPDATE wirds SET doneDays = :doneDates WHERE id = :wirdId")
    fun updateDoneDates(wirdId: Int, doneDates: List<LocalDateTime>)*/

    @Query("UPDATE wirds SET wirdDays = :wirdDays WHERE id = :wirdId")
    fun updateWirdDays(wirdId: Int, wirdDays: List<LocalDateTime>)
}