package com.ravnnerdery.starwarschallenge.application

import android.os.Build.VERSION.SDK_INT
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.ravnnerdery.starwarschallenge.ui.theme.ApplicationTheme
import com.ravnnerdery.starwarschallenge.ui.Application
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val imgLoader = ImageLoader.invoke(this).newBuilder()
            .componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder(this@MainActivity))
                } else {
                    add(GifDecoder())
                }
            }.build()
        setContent {
            ApplicationTheme {
                Scaffold {
                    Application(viewModel = mainViewModel, imageLoader = imgLoader)
                }
            }
        }
    }
}