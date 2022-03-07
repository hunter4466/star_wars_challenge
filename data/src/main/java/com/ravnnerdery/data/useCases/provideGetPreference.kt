package com.ravnnerdery.data.useCases

import com.ravnnerdery.domain.models.Preference
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface ProvideGetPreferenceUseCase {
    fun execute(): Flow<List<Preference>>
}

class ProvideGetPreferenceUseCaseImpl @Inject constructor(private val repo: MainRepository): ProvideGetPreferenceUseCase {
    override fun execute(): Flow<List<Preference>> {
        return repo.getPreferences()
    }
}

class ProvideGetPreferenceUseCaseTest(): ProvideGetPreferenceUseCase {
    override fun execute(): Flow<List<Preference>> = flow {
        emit(
            listOf(
                Preference(1,"id_1",false),
                Preference(2,"id_2",true),
                Preference(3,"id_3",false),
                Preference(4,"id_4",true),
                Preference(5,"id_5",false)
            )
        )
    }
}