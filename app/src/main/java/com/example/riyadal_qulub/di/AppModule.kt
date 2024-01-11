package com.example.riyadal_qulub.di

import android.app.Application
import androidx.room.Room
import com.example.riyadal_qulub.data.local.db.WirdDatabase
import com.google.firebase.auth.FirebaseAuth
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWirdDatabase(app: Application): WirdDatabase {
        return Room.databaseBuilder(
            app,
            WirdDatabase::class.java,
            "wird_db.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }

}


