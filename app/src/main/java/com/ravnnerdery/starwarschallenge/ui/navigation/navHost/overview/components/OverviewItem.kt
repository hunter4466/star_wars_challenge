package com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.ravnnerdery.starwarschallenge.R

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
        Column {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
            ) {
                Column() {
                    Text(text = name, style = MaterialTheme.typography.h5, color = Color.DarkGray)
                    Text(
                        text = "$specie from $homeWorld",
                        style = MaterialTheme.typography.subtitle1,
                        color = Color.Gray
                    )
                }
                Column(modifier = Modifier.padding(16.dp, 16.dp, 32.dp, 16.dp)) {
                    Icon(
                        painter = painterResource(id = R.drawable.right_arrow),
                        contentDescription = null
                    )
                }
            }
            Divider(color = Color.DarkGray, thickness = 1.dp)
        }
    }
}