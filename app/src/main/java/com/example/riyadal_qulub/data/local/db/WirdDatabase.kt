package com.example.riyadal_qulub.data.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.riyadal_qulub.domain.model.Wird
import com.example.riyadal_qulub.util.DatabaseConstants.DATABASE_NAME


@Database(entities = [Wird::class], version = 1)
@TypeConverters(Converters::class)
abstract class WirdDatabase : RoomDatabase() {

    abstract val dao : WirdDao

    companion object {
        private var INSTANCE: WirdDatabase? = null
        fun getDatabase(context: Context): WirdDatabase {
            if (INSTANCE == null) {
                INSTANCE = androidx.room.Room.databaseBuilder(
                    context.applicationContext,
                    WirdDatabase::class.java,
                    DATABASE_NAME
                ).build()
            }
            return INSTANCE!!
        }
    }
}
