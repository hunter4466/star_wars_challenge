package com.ravnnerdery.starwarschallenge.ui.navigation.navHost.detail.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ListCard(
    header: String,
    content: String,
    color: Color,
) {
    Column(
        modifier = Modifier.padding(start = 16.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(0.dp, 16.dp, 16.dp, 16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = header, style = MaterialTheme.typography.h6, color = color)
            Text(text = content, style = MaterialTheme.typography.h6, color = Color.Black)
        }
        Divider(color = Color.DarkGray, thickness = 1.dp)
    }
}