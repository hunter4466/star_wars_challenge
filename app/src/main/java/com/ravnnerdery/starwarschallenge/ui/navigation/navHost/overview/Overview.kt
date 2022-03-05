package com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview.components.OverviewItem

@Composable
fun Overview(
    charactersList: LazyPagingItems<Character>,
    onClick: (String) -> Unit
) {

    LazyColumn{
        itemsIndexed(charactersList) { _, item ->
            if(item != null) {
                OverviewItem(name = item.name, specie = item.species, homeWorld = item.homeworld, onclick = { onClick(item.name) })
            }
        }
    }

}