package com.ravnnerdery.data.repository

import androidx.paging.*
import com.ravnnerdery.data.network.CharactersPagingDataSource
import com.ravnnerdery.domain.models.*
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(
    private val dataSource: CharactersPagingDataSource,
) : MainRepository {

    @OptIn(ExperimentalPagingApi::class)
    override fun provideCharactersPaging(): Flow<PagingData<Character>> = Pager(
            config = PagingConfig(pageSize = 20),
            initialKey = "home"
        )
    {
        dataSource
    }.flow
}