package com.ravnnerdery.domain.repository

import com.ravnnerdery.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun loadItemsFromApi(): Flow<List<Character>>
}