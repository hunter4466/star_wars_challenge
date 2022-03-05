package com.ravnnerdery.data.repository

import android.util.Log
import androidx.paging.*
import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.database.StarWarsDataBase
import com.ravnnerdery.data.network.ApolloClientProvider
import com.ravnnerdery.data.network.CharactersPagingDataSource
import com.ravnnerdery.domain.models.*
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(
    private val databaseDao: DatabaseDao,
    private val database: StarWarsDataBase,
    private val apolloClient: ApolloClientProvider,
) : MainRepository {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    @OptIn(ExperimentalPagingApi::class)
    override suspend fun provideCharactersPaging(): Flow<PagingData<Character>> = Pager(
            config = PagingConfig(pageSize = 20),
            remoteMediator = AppRemoteMediator(database, databaseDao, apolloClient),
            initialKey = "YXJyYXljb25uZWN0aW9uOjk="
        )
    {
        CharactersPagingDataSource(databaseDao)
    }.flow.cachedIn(uiScope)
}