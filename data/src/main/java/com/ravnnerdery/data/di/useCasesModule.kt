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
    fun provideCharactersPagingUseCase(
        provideCharactersPagingUseCaseImpl : ProvideCharactersPagingUseCaseImpl
    ): ProvideCharactersPagingUseCase {
        return provideCharactersPagingUseCaseImpl
    }

    @Provides
    @Singleton
    fun provideGetPreferenceUseCase(
        provideGetPreferenceUseCaseImpl : ProvideGetPreferenceUseCaseImpl
    ): ProvideGetPreferenceUseCase {
        return provideGetPreferenceUseCaseImpl
    }
    @Provides
    @Singleton
    fun provideUpdatePreferenceUseCase(
        provideUpdatePreferenceUseCaseImpl : ProvideUpdatePreferenceUseCaseImpl
    ): ProvideUpdatePreferenceUseCase {
        return provideUpdatePreferenceUseCaseImpl
    }
}