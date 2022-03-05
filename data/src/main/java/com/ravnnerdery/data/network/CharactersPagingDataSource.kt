package com.ravnnerdery.data.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.mappers.mapToDatabaseModel
import com.ravnnerdery.data.mappers.mapToDomainModel
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.GetAllPeopleQuery
import kotlinx.coroutines.*
import javax.inject.Inject

class CharactersPagingDataSource @Inject constructor(
    private val apolloClient: ApolloClientProvider,
    private val databaseDao: DatabaseDao,
) :

    PagingSource<String, Character>() {
    override fun getRefreshKey(state: PagingState<String, Character>): String {
        return state.anchorPosition.toString()
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Character> {
        return try {
            withContext(Dispatchers.IO) {
                val response = apolloClient.apolloClientInstance()
                    .query(GetAllPeopleQuery(5, params.key)).execute()

                val data = response.data?.allPeople?.edges?.map { mapToDomainModel(it) }
                data?.forEach {
                    Log.wtf("BUGCHASE", "trying to implement${it.name}")
                }
                data?.forEach {
                    try {
                        databaseDao.insertCharacter(mapToDatabaseModel(it))
                    } catch (e: Exception) {
                        Log.wtf("BUGCHASE", "database error ${e}")
                    }
                }
                var nextPageIndex: String? = null
                if (response.data?.allPeople?.edges?.isNotEmpty() == true) {
                    if (response.data?.allPeople?.pageInfo?.hasNextPage == true) {
                        nextPageIndex = response.data?.allPeople?.pageInfo?.endCursor
                    }
                }
                LoadResult.Page(
                    data = data.orEmpty(),
                    prevKey = null,
                    nextKey = nextPageIndex
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }
}