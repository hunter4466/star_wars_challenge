package com.ravnnerdery.starwarschallenge.ui.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.paging.compose.LazyPagingItems
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.NavigationHost
import com.ravnnerdery.starwarschallenge.ui.navigation.topbar.TopBar

@Composable
fun Navigation(
    navController: NavHostController,
    charactersList: LazyPagingItems<Character>,
    topBarTitle: String,
    hasBackIcon: Boolean,
    onNavigated: (String) -> Unit,
    onNavigatedBack: () -> Unit,
) {
    Column {
        TopBar(
            title = topBarTitle,
            onButtonClicked = {
                onNavigatedBack()
                navController.navigate("overview")
                              },
            hasBackIcon = hasBackIcon,

        )

        NavigationHost(
            navController = navController,
            charactersList = charactersList,
            onNavigated = { onNavigated(it) }
        )
    }


}