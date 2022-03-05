package com.ravnnerdery.starwarschallenge.ui.navigation.topbar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(title: String, onButtonClicked: () -> Unit, hasBackIcon: Boolean) {
    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(end = 80.dp)
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