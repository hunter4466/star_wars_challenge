package com.ravnnerdery.starwarschallenge.application

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Scaffold
import com.ravnnerdery.starwarschallenge.ui.theme.ApplicationTheme
import com.ravnnerdery.starwarschallenge.ui.Application
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ApplicationTheme {
                Scaffold {
                    Application(viewModel = mainViewModel)
                }
            }
        }
    }
}