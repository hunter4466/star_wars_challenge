package com.ravnnerdery.data.network

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ravnnerdery.data.database.DatabaseDao
import com.ravnnerdery.data.mappers.mapToDomainModel
import com.ravnnerdery.domain.models.Character
import kotlinx.coroutines.*

class CharactersPagingDataSource(
    private val databaseDao: DatabaseDao
) :

    PagingSource<String, Character>() {
    override fun getRefreshKey(state: PagingState<String, Character>): String {
        return state.anchorPosition.toString()
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Character> {
        return try {
            withContext(Dispatchers.IO) {
                Log.wtf("BUGCHASE","TRYING TO LOAD from db ${params.key}")
              val response = databaseDao.getCharactersByPage(params.key ?: "")
                if (response.isNotEmpty()) Log.wtf("BUGCHASE","SUCCESS LOADING FROM DB ${response.size} elements") else Log.wtf("BUGCHASE","COULDN'T LOAD FROM DB")
                val data = response.map { mapToDomainModel(it) }
                var nextPageIndex: String? = null
                if (response.isNotEmpty()) {
                    if (response.last().hasNextPage) {
                        Log.wtf("BUGCHASE","loaded nextPagIndex with ${response.first().groupStartCursor}")
                       nextPageIndex = response.first().groupStartCursor
                    }
                }
                Log.wtf("BUGCHASE","TRYING TO LOAD NEXT WITH ${nextPageIndex}")
                LoadResult.Page(
                    data = data,
                    prevKey = null,
                    nextKey = nextPageIndex
                )
            }
        } catch (e: Exception) {
           LoadResult.Error(e)
        }

    }
}