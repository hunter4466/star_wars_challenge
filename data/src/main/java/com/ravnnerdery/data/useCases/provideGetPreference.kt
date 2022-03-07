package com.ravnnerdery.data.useCases

import com.ravnnerdery.domain.models.Preference
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ProvideGetPreferenceUseCase {
    fun execute(): Flow<List<Preference>>
}

class ProvideGetPreferenceUseCaseImpl @Inject constructor(private val repo: MainRepository): ProvideGetPreferenceUseCase {
    override fun execute(): Flow<List<Preference>> {
        return repo.getPreferences()
    }
}