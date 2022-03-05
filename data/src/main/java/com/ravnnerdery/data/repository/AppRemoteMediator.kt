package com.ravnnerdery.data.repository

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.database.StarWarsDataBase
import com.ravnnerdery.data.mappers.mapToDatabaseModel
import com.ravnnerdery.data.network.ApolloClientProvider
import com.ravnnerdery.data.utils.randLabelGen
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery
import com.ravnnerdery.starwarschallenge.GetNextIndexQuery
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class AppRemoteMediator(
    private val database: StarWarsDataBase,
    private val databaseDao: DatabaseDao,
    private val apolloClient: ApolloClientProvider,
) : RemoteMediator<String, Character>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<String, Character>
    ): MediatorResult {
        Log.wtf("BUGCHASE", "MEDIATOR CONSULTED")
        return try {
            withContext(Dispatchers.IO) {
            val loadKey = when (loadType) {
                LoadType.REFRESH -> null
                LoadType.PREPEND -> return@withContext MediatorResult.Success(endOfPaginationReached = true)
                LoadType.APPEND -> {
                    val lastItem = state.lastItemOrNull()

                    if (lastItem == null) {
                        return@withContext MediatorResult.Success(
                            endOfPaginationReached = true
                        )
                    }
                    lastItem.groupEndCursor
                }
            }
            Log.wtf("BUGCHASE", "MEDIATOR CONSULTED WITH LOADKEY ${loadKey}")
            val response = apolloClient.apolloClientInstance()
                .query(GetAllPeopleQuery(state.config.pageSize, loadKey)).execute()
            Log.wtf("BUGCHASE", " RESPONSE: ${response.data?.allPeople}")
            val nextKey = apolloClient.apolloClientInstance()
                .query(GetNextIndexQuery(response.data?.allPeople?.pageInfo?.endCursor))
                .execute().data?.allPeople?.pageInfo?.startCursor
            val randomLabel = randLabelGen()


            var label = "YXJyYXljb25uZWN0aW9uOjk="
            if (loadType == LoadType.APPEND) {
                label = response.data?.allPeople?.pageInfo?.endCursor ?: randomLabel
            }

            response.data?.allPeople?.edges?.forEach {
                databaseDao.insertCharacter(
                    mapToDatabaseModel(
                        response = it,
                        label = label,
                        hasNextPage = response.data?.allPeople?.pageInfo?.hasNextPage ?: false,
                        hasPreviousPage = response.data?.allPeople?.pageInfo?.hasPreviousPage
                            ?: false,
                        groupStartCursor = nextKey ?: "undefined",
                        groupEndCursor = response.data?.allPeople?.pageInfo?.endCursor
                            ?: "Undefined",
                    )
                )
            }
            database.lastUpdated = System.currentTimeMillis()

            MediatorResult.Success(
                endOfPaginationReached = response.data?.allPeople?.pageInfo?.endCursor == null
            )
        }
        } catch (e: IOException) {
            MediatorResult.Error(e)
        }
    }

    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)
        return if (System.currentTimeMillis() - database.lastUpdated >= cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }
}