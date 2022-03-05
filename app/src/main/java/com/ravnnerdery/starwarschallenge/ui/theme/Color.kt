package com.ravnnerdery.starwarschallenge.ui.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val black1000 = Color(color = 0xCB000000)
val white1000 = Color(color = 0xFFC8C8C8)

val DarkColors = darkColors(
    primary = Color.White,
    primaryVariant = Color.White, // white1000
    onPrimary = Color.Black,
    secondary = Color.White,
    secondaryVariant = Color.White, // white1000
    onSecondary = Color.Black,
    error = Color.Red
)

val LightColors = lightColors(
    primary = Color.Black,
    primaryVariant = Color.Black, // black1000
    onPrimary = Color.White,
    secondary = Color.Black,
    secondaryVariant = Color.Black, // black1000
    onSecondary = Color.White,
    error = Color.Red
)

