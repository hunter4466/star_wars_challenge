package com.ravnnerdery.starwarschallenge.ui.navigation.navHost.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ravnnerdery.domain.models.Character
import com.ravnnerdery.starwarschallenge.ui.navigation.navHost.detail.components.ListCard

@Composable
fun Detail(activeCharacter: Character) {
    LazyColumn() {
        item {
            Column(modifier = Modifier.padding(top = 32.dp)) {
                Text(
                    text = "General Information",
                    modifier = Modifier.padding(start = 16.dp),
                    style = MaterialTheme.typography.h6
                )
                ListCard("Eye Color", activeCharacter.eyeColor, Color.Gray)
                ListCard("Hair Color", activeCharacter.hairColor, Color.Gray)
                ListCard("Skin Color", activeCharacter.skinColor, Color.Gray)
                ListCard("Birth Year", activeCharacter.birthYear, Color.Gray)
            }
            Column(modifier = Modifier.padding(top = 32.dp)) {
                Text(
                    text = "Vehicles",
                    modifier = Modifier.padding(start = 16.dp),
                    style = MaterialTheme.typography.h6
                )
                if (activeCharacter.vehicles.isEmpty()) {
                    ListCard("No vehicles found", "", Color.Red)
                } else {
                    activeCharacter.vehicles.forEach {
                        ListCard(it, "", Color.Gray)
                    }
                }
            }
        }
    }
}