package com.ravnnerdery.data.repository

import androidx.paging.*
import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.database.models.PreferencesEntity
import com.ravnnerdery.data.network.CharactersPagingDataSource
import com.ravnnerdery.domain.models.*
import com.ravnnerdery.domain.repository.MainRepository
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(
    private val dataSource: CharactersPagingDataSource,
    private val databaseDao: DatabaseDao,
) : MainRepository {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)

    @OptIn(ExperimentalPagingApi::class)
    override fun provideCharactersPaging(): Flow<PagingData<Character>> = Pager(
        config = PagingConfig(pageSize = 20),
    )
    {
        dataSource
    }.flow

    override fun updatePreference(key: String, pref: Boolean) {
        uiScope.launch(Dispatchers.IO) {
            databaseDao.insertPreference(PreferencesEntity(apiId = key, preference = pref))
        }
    }

    override fun getPreferences(): Flow<List<Preference>> = flow {
        while (true) {
            emit(
                databaseDao.getAllPreferences().map {
                    it.mapToDomainModel()
                }
            )
            delay(1000)
        }
    }.flowOn(Dispatchers.IO)
}