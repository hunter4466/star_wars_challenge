package com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.itemsIndexed
import coil.ImageLoader
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.domain.models.Preference
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview.components.Loading
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview.components.OverviewItem

@Composable
fun Overview(
    imageLoader: ImageLoader,
    charactersList: LazyPagingItems<Character>,
    onClick: (Character) -> Unit,
    filter: String,
    onPrefClicked: (String, Boolean) -> Unit,
    prefList: List<Preference>
) {

    LazyColumn{
        itemsIndexed(charactersList) { _, item ->
            if(item != null) {
                if(item.name.lowercase().contains(filter.lowercase())){
                    OverviewItem(
                        name = item.name,
                        specie = item.species,
                        homeWorld = item.homeworld,
                        onclick = { onClick(item) },
                        id = item.id,
                        onPrefClicked = { key, pref -> onPrefClicked(key, pref)},
                        prefList = prefList)
                }
            }
        }
        if(charactersList.loadState.append == LoadState.Loading){
            item{
                Loading(imageLoader = imageLoader)
            }
        }
    }
}