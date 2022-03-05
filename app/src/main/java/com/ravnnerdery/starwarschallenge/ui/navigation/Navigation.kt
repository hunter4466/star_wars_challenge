package com.ravnnerdery.starwarschallenge.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import coil.ImageLoader
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.NavigationHost
import com.ravnnerdery.starwarschallenge.ui.navigation.topbar.TopBar

@Composable
fun Navigation(
    imageLoader: ImageLoader,
    activeCharacter: Character,
    navController: NavHostController,
    charactersList: LazyPagingItems<Character>,
    topBarTitle: String,
    hasBackIcon: Boolean,
    onNavigated: (Character) -> Unit,
    onNavigatedBack: () -> Unit,
    onClearSearchClicked: () -> Unit,
    hasSearchBar: Boolean,
    searchText: String,
    onSearchTextChanged: (String) -> Unit,
    onCloseSearchBar: () -> Unit,
    filter: String,
) {
    Column {
        TopBar(
            title = topBarTitle,
            onButtonClicked = {
                onNavigatedBack()
                navController.navigate("overview")
                              },
            hasBackIcon = hasBackIcon,
            onClearSearchClicked = { onClearSearchClicked() },
            hasSearchBar = hasSearchBar,
            searchText = searchText,
            onSearchTextChanged = { onSearchTextChanged(it) },
            onCloseSearchBar = { onCloseSearchBar() }
        )

        NavigationHost(
            imageLoader = imageLoader,
            activeCharacter = activeCharacter,
            navController = navController,
            charactersList = charactersList,
            onNavigated = { onNavigated(it) },
            filter = filter,
        )
    }


}