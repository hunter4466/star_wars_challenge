package com.ravnnerdery.data.useCases

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.ravnnerdery.data.network.TestingPagingDataSource
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface ProvideCharactersPagingUseCase {
    fun  execute(): Flow<PagingData<Character>>
}

class ProvideCharactersPagingUseCaseImpl @Inject constructor(private val repo: MainRepository): ProvideCharactersPagingUseCase {
    override fun execute(): Flow<PagingData<Character>>  = repo.provideCharactersPaging()
}

class ProvideCharactersPagingUseCasetest(): ProvideCharactersPagingUseCase {
    @OptIn(ExperimentalPagingApi::class)
    override fun execute(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 20),
        initialKey = "home"
    )
    {
        TestingPagingDataSource()
    }.flow
}