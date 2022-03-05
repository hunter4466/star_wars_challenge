package com.ravnnerdery.starwarschallenge.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.application.MainViewModel
import com.ravnnerdery.starwarschallenge.ui.navigation.Navigation

@Composable
fun Application(viewModel: MainViewModel) {
    var topBarTitle by remember { mutableStateOf("People of Star Wars") }
    var hasBackIcon by remember { mutableStateOf(false) }
    val navController = rememberNavController()
    val lazyPagingItems: LazyPagingItems<Character>? = viewModel.charactersList?.collectAsLazyPagingItems()

    Column {
        if (lazyPagingItems != null) {
            Navigation(
                topBarTitle = topBarTitle,
                hasBackIcon = hasBackIcon,
                navController = navController,
                charactersList = lazyPagingItems,
                onNavigated = {
                    topBarTitle = it
                    hasBackIcon = true
                },
                onNavigatedBack = {
                    hasBackIcon = false
                    topBarTitle = "People of Star Wars"
                }
            )
        }
    }
}