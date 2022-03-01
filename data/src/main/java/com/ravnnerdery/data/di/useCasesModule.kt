package com.ravnnerdery.data.di

import com.ravnnerdery.data.useCases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class UseCasesModule {

    @Provides
    @Singleton
    fun loadItemsFromApiUseCase(
        loadItemsFromApiUseCaseImpl: LoadItemsFromApiUseCaseImpl
    ): LoadItemsFromApiUseCase  {
        return loadItemsFromApiUseCaseImpl
    }

}