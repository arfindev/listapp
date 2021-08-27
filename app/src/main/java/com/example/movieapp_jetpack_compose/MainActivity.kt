package com.example.movieapp_jetpack_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.input.KeyboardType.Companion.Text
import com.example.movieapp_jetpack_compose.ComposeUi.MovieDataList
import com.example.movieapp_jetpack_compose.ComposeUi.RecyclerView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val MovieClass = MovieDataList()
            val getMovieAllData = MovieClass.getMovieData()

            RecyclerView(movieLists = getMovieAllData)



        }
    }
}