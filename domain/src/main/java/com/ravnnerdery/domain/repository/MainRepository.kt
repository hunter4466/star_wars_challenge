package com.ravnnerdery.domain.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.domain.models.Preference
import kotlinx.coroutines.flow.Flow

interface MainRepository {
    fun provideCharactersPaging(): Flow<PagingData<Character>>
    fun updatePreference(key: String, pref: Boolean)
    fun getPreferences(): Flow<List<Preference>>
}