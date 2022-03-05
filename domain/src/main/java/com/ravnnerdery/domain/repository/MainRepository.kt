package com.ravnnerdery.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import com.ravnnerdery.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun provideCharactersPaging(): Flow<PagingData<Character>>
}