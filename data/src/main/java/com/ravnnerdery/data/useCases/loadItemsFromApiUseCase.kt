package com.ravnnerdery.data.useCases

import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface LoadItemsFromApiUseCase {
    fun execute(): Flow<List<Character>>
}

class LoadItemsFromApiUseCaseImpl @Inject constructor(private val repo: MainRepository) : LoadItemsFromApiUseCase {
    override fun execute() = repo.loadItemsFromApi()
}