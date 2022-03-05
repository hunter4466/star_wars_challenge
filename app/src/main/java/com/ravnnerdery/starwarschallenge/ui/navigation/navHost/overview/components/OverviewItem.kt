package com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Border(val strokeWidth: Dp, val color: Color)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OverviewItem(
    name: String,
    specie: String,
    homeWorld: String,
    onclick: (String) -> Unit,
) {
    Card(
        onClick = { onclick(name) },
        modifier = Modifier.padding(start = 16.dp),
    ) {
        Column() {
            Text(text = name, style = MaterialTheme.typography.h6)
            Text(text = "$specie from $homeWorld")
        }
    }
}