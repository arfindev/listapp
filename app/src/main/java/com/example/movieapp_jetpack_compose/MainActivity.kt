package com.example.movieapp_jetpack_compose

import android.content.pm.ModuleInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val MovieNames = MovieData()
            val getAlldatas = MovieNames.getAllData()
            Recyclerview(users = getAlldatas)

        }
    }

    @Composable
    fun LazyColumns(movie: Movie) {
        Card(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            shape = RoundedCornerShape(
                CornerSize(5.dp)
            ), elevation = 2.dp
        ) {
            Row(modifier = Modifier.padding(5.dp)) {
                Image(
                    painter = painterResource(id = R.mipmap.scoobydoo),
                    contentDescription = "ScoobyDoo",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(80.dp)
                        .align(Alignment.CenterVertically)
                        .clip(RoundedCornerShape(CornerSize(10.dp)))
                )
                Text(text = movie.title, modifier = Modifier.padding(8.dp))
            }
        }
    }

    @Composable
    fun Recyclerview(users:List<Movie>){
        LazyRow{
            items(users){user->
                LazyColumns(user)
            }
        }
    }
}