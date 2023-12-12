package com.example.riyadal_qulub.di

import com.example.riyadal_qulub.domain.repository.WirdRepository
import com.example.riyadal_qulub.data.repository.WirdRepositoryImp
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindWirdRepository(
        bindWirdRepository: WirdRepositoryImp
    ): WirdRepository

}