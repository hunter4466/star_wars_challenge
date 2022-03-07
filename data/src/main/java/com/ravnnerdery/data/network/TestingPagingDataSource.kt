package com.ravnnerdery.data.network

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.ravnnerdery.domain.models.Character
import javax.inject.Inject

fun getData(): List<Character> {
    return listOf(
        Character(
            cursor = "cursor1",
            id = "id_1",
            name = "name 1",
            species = "species 1",
            homeworld = "homeworld 1",
            eyeColor = "eyeColor 1",
            hairColor = "hairColor 1",
            skinColor = "skinColor 1",
            birthYear = "birthYear 1",
            vehicles = listOf("vehicle 1", "vehicle 2", "vehicle 3")
        ),
        Character(
            cursor = "cursor2",
            id = "id_2",
            name = "name 2",
            species = "species 2",
            homeworld = "homeworld 2",
            eyeColor = "eyeColor 2",
            hairColor = "hairColor 2",
            skinColor = "skinColor 2",
            birthYear = "birthYear 2",
            vehicles = listOf("vehicle 4", "vehicle 5", "vehicle 6")
        ),
        Character(
            cursor = "cursor3",
            id = "id_3",
            name = "name 3",
            species = "species 3",
            homeworld = "homeworld 3",
            eyeColor = "eyeColor 3",
            hairColor = "hairColor 3",
            skinColor = "skinColor 3",
            birthYear = "birthYear 3",
            vehicles = listOf("vehicle 7", "vehicle 8", "vehicle 9")
        )
    )
}

class TestingPagingDataSource @Inject constructor() :

    PagingSource<String, Character>() {
    override fun getRefreshKey(state: PagingState<String, Character>): String {
        return state.anchorPosition.toString()
    }

    override suspend fun load(params: LoadParams<String>): LoadResult<String, Character> {
        val response = getData()

        return LoadResult.Page(
            data = response,
            prevKey = null,
            nextKey = null
        )
    }
}