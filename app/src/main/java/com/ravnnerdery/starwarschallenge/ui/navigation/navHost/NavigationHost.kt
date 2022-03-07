package com.ravnnerdery.starwarschallenge.ui.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.LazyPagingItems
import coil.ImageLoader
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.domain.models.Preference
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.detail.Detail
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview.Overview

@Composable
fun NavigationHost(
    imageLoader: ImageLoader,
    activeCharacter: Character,
    navController: NavHostController,
    charactersList: LazyPagingItems<Character>,
    onNavigated: (Character) -> Unit,
    filter: String,
    prefList: List<Preference>,
    onPrefClicked: (String, Boolean) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = "overview"
    ) {
        composable("overview") {
            Overview(
                imageLoader = imageLoader,
                charactersList = charactersList,
                onClick = {
                    onNavigated(it)
                    navController.navigate("detail")
                },
                filter = filter,
                onPrefClicked = { key, pref -> onPrefClicked(key, pref)},
                prefList = prefList
            )
        }
        composable("detail") { Detail(activeCharacter = activeCharacter) }
    }
}