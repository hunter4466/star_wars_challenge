package com.ravnnerdery.starwarschallenge.ui

import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.collectAsLazyPagingItems
import coil.ImageLoader
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.application.MainViewModel
import com.ravnnerdery.starwarschallenge.ui.navigation.Navigation
import com.ravnnerdery.starwarschallenge.ui.navigation.topbar.components.SearchIcon

@Composable
fun Application(viewModel: MainViewModel, imageLoader: ImageLoader) {
    var topBarTitle by remember { mutableStateOf("People of Star Wars") }
    var hasBackIcon by remember { mutableStateOf(false) }
    var hasSearchBar by remember { mutableStateOf(false) }
    var userSearchState by remember { mutableStateOf("") }
    var activeCharacter by remember {
        mutableStateOf(
            Character(
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                "",
                emptyList()
            )
        )
    }
    val navController = rememberNavController()
    val lazyPagingItems: LazyPagingItems<Character>? =
        viewModel.charactersList?.collectAsLazyPagingItems()
    val prefList = viewModel.getPreferences().collectAsState(initial = emptyList())

    if (lazyPagingItems != null) {
        Navigation(
            imageLoader = imageLoader,
            activeCharacter = activeCharacter,
            topBarTitle = topBarTitle,
            hasBackIcon = hasBackIcon,
            navController = navController,
            charactersList = lazyPagingItems,
            onNavigated = {
                topBarTitle = it.name
                hasBackIcon = true
                activeCharacter = it
                hasSearchBar = false
                userSearchState = ""
            },
            onNavigatedBack = {
                hasBackIcon = false
                topBarTitle = "People of Star Wars"
            },
            onClearSearchClicked = { userSearchState = "" },
            hasSearchBar = hasSearchBar,
            searchText = userSearchState,
            onSearchTextChanged = { userSearchState = it },
            onCloseSearchBar = { hasSearchBar = false },
            filter = userSearchState,
            prefList = prefList.value,
            onPrefClicked = { key, pref ->  viewModel.updatePreference(key, pref) }
        )
        if (!hasSearchBar) {
            SearchIcon(
                onSearchClicked = { hasSearchBar = true }
            )
        }
    }
}