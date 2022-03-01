package com.ravnnerdery.starwarschallenge.application

import androidx.lifecycle.ViewModel
import com.ravnnerdery.data.useCases.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val loadItemsFromApiUseCase: LoadItemsFromApiUseCase
) : ViewModel() {
    val charactersList = loadItemsFromApiUseCase.execute()
}