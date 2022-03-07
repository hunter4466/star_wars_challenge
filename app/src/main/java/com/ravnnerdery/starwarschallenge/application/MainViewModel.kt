package com.ravnnerdery.starwarschallenge.application

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import com.ravnnerdery.data.useCases.*
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.domain.models.Preference
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    provideCharactersPagingUseCase: ProvideCharactersPagingUseCase,
    private val provideGetPreferenceUseCase: ProvideGetPreferenceUseCase,
    private val provideUpdatePreferenceUseCase: ProvideUpdatePreferenceUseCase
) : ViewModel() {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var charactersList: Flow<PagingData<Character>>? = provideCharactersPagingUseCase.execute()
    fun updatePreference(key: String, pref: Boolean) {
        provideUpdatePreferenceUseCase.execute(key, pref)
    }
    fun getPreferences(): Flow<List<Preference>> = provideGetPreferenceUseCase.execute()
}