package com.ravnnerdery.data.di

import androidx.paging.PagingSource
import com.ravnnerdery.data.network.ApolloClientProvider
import com.ravnnerdery.data.network.ApolloClientProviderImpl
import com.ravnnerdery.data.network.CharactersPagingDataSource
import com.ravnnerdery.domain.models.Character
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClientProvider {
        return ApolloClientProviderImpl()
    }

    @Provides
    @Singleton
    fun providePagingDataSource(
        charactersPagingDataSource: CharactersPagingDataSource
    ): PagingSource<String, Character> {
        return charactersPagingDataSource
    }
}