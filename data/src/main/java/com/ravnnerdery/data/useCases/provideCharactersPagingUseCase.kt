package com.ravnnerdery.data.useCases

import androidx.paging.Pager
import androidx.paging.PagingData
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

interface ProvideCharactersPagingUseCase {
    fun  execute(): Flow<PagingData<Character>>
}

class ProvideCharactersPagingUseCaseImpl @Inject constructor(private val repo: MainRepository): ProvideCharactersPagingUseCase {
    override fun execute(): Flow<PagingData<Character>>  = repo.provideCharactersPaging()
}