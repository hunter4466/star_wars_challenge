package com.ravnnerdery.starwarschallenge.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.*
import com.ravnnerdery.starwarschallenge.application.MainViewModel

@Composable
fun Application(viewModel: MainViewModel) {
    val charactersList by viewModel.charactersList.collectAsState(initial = emptyList())
    LazyColumn{
        if (charactersList.isNotEmpty()) {
            charactersList.forEach { character ->
                item {
                    Text(text = character.name)
                }
            }
        }
    }


}