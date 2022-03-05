package com.ravnnerdery.starwarschallenge.application

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import androidx.paging.compose.LazyPagingItems
import com.ravnnerdery.data.useCases.*
import com.ravnnerdery.domain.models.Character
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val provideCharactersPagingUseCase: ProvideCharactersPagingUseCase,
) : ViewModel() {
    private var viewModelJob = Job()
    private val uiScope = CoroutineScope(Dispatchers.Main + viewModelJob)
    var charactersList: Flow<PagingData<Character>>? = provideCharactersPagingUseCase.execute()

}