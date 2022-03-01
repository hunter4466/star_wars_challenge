package com.ravnnerdery.data.repository

import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.mappers.mapToDatabaseModel
import com.ravnnerdery.data.network.ApolloClientProvider
import com.ravnnerdery.domain.models.*
import com.ravnnerdery.domain.repository.MainRepository
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class MainRepositoryImpl @Inject constructor(
    private val databaseDao: DatabaseDao,
    private val apolloClient: ApolloClientProvider
): MainRepository {

    override fun loadItemsFromApi(): Flow<List<Character>> = flow {
        val response = apolloClient.apolloClientInstance().query(GetAllPeopleQuery()).execute()
        response.data?.allPeople?.edges?.forEach { edge ->
            databaseDao.insertCharacter(mapToDatabaseModel(edge))
        }
        val charactersTempList = mutableListOf<Character>()
        databaseDao.getCharacters().forEach {
            charactersTempList.add(it.mapToDomainModel())
        }
        emit(charactersTempList)
    }.flowOn(Dispatchers.IO)
}