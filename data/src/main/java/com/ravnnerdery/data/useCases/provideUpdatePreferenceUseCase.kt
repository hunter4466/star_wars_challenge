package com.ravnnerdery.data.useCases

import com.ravnnerdery.domain.repository.MainRepository
import javax.inject.Inject

interface ProvideUpdatePreferenceUseCase {
    fun execute(key: String, pref: Boolean)
}

class ProvideUpdatePreferenceUseCaseImpl @Inject constructor(private val repo: MainRepository): ProvideUpdatePreferenceUseCase {
    override fun execute(key: String, pref: Boolean) {
        repo.updatePreference(key, pref)
    }
}