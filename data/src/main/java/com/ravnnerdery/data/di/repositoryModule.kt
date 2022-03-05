package com.ravnnerdery.data.di

import androidx.paging.ExperimentalPagingApi
import androidx.paging.RemoteMediator
import com.ravnnerdery.data.repository.AppRemoteMediator
import com.ravnnerdery.data.repository.MainRepositoryImpl
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.domain.repository.MainRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @OptIn(ExperimentalCoroutinesApi::class)
    @Provides
    @Singleton
    fun provideMainRepositoryImpl(repository: MainRepositoryImpl): MainRepository {
        return repository
    }

    @OptIn(ExperimentalPagingApi::class)
    fun provideRemoteMediator(
        remoteMediator: AppRemoteMediator
    ): RemoteMediator<String, Character> {
        return remoteMediator
    }
}