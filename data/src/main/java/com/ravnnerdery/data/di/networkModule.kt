package com.ravnnerdery.data.di

import com.ravnnerdery.data.network.ApolloClientProvider
import com.ravnnerdery.data.network.ApolloClientProviderImpl
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

}