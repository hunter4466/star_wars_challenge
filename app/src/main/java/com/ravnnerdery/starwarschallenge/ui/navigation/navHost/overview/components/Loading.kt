package com.ravnnerdery.starwarschallenge.ui.navigation.navHost.overview.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.ravnnerdery.starwarschallenge.R
import coil.ImageLoader
import coil.compose.rememberImagePainter

@Composable
fun Loading(imageLoader: ImageLoader) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Loading",
            color = Color.Gray,
            style = MaterialTheme.typography.h5
        )
        Image(
            painter = rememberImagePainter(
                data = R.drawable.loadingbuffering,
                imageLoader = imageLoader
            ),
            contentDescription = null,
            modifier = Modifier.size(40.dp)
        )
    }
}