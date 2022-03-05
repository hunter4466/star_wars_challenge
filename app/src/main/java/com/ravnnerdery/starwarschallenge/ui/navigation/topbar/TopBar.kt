package com.ravnnerdery.starwarschallenge.ui.navigation.topbar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.ravnnerdery.starwarschallenge.ui.navigation.topbar.components.SearchIcon
import com.ravnnerdery.starwarschallenge.ui.navigation.topbar.components.SearchTopBar

@Composable
fun TopBar(
    title: String,
    onButtonClicked: () -> Unit,
    onClearSearchClicked: () -> Unit,
    onSearchTextChanged: (String) -> Unit,
    onCloseSearchBar: () -> Unit,
    hasBackIcon: Boolean,
    hasSearchBar: Boolean,
    searchText: String,
) {
    if (hasSearchBar) {
        SearchTopBar(
            searchText = searchText,
            placeHolderText = "Input name",
            onSearchTextChanged = { onSearchTextChanged(it) },
            onClearSearchClicked = {onClearSearchClicked()},
            onCloseSearchBar = { onCloseSearchBar() },
        )
    } else {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 80.dp)
                )
            },
            navigationIcon = {
                if (hasBackIcon) {
                    IconButton(
                        onClick = { onButtonClicked() }
                    ) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "")
                    }
                }
            },
            backgroundColor = MaterialTheme.colors.primaryVariant,
        )
    }
}