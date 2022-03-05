package com.ravnnerdery.starwarschallenge.ui.navigation.navHost

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.LazyPagingItems
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.detail.Detail
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview.Overview

@Composable
fun NavigationHost(
    navController: NavHostController,
    charactersList: LazyPagingItems<Character>,
    onNavigated: (String) -> Unit,
) {
    NavHost(
        navController = navController,
        startDestination = "overview"
    ) {
        composable("overview") {
            Overview(
                charactersList = charactersList,
                onClick = {
                    onNavigated(it)
                    navController.navigate("detail")
                }
            )
        }
        composable("detail") { Detail() }
    }
}