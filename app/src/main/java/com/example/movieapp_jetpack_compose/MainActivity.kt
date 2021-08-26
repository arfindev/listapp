package com.example.movieapp_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val MovieNames = MovieData()
            val getAlldatas = MovieNames.getAllData()
            Recycleview(movie = getAlldatas)

        }
    }

    }