package com.example.movieapp_jetpack_compose.ComposeUi

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.recyclerview.widget.RecyclerView

@Composable
fun EachRow(movieLists: MovieDataClass) {
    val checkedState = remember { mutableStateOf(false) }



    Card(modifier = Modifier
        .padding(8.dp)
        .fillMaxWidth(),
         shape = RoundedCornerShape(CornerSize(10.dp)))
    {
        Row {
          Image(painter = painterResource(id = movieLists.image),
              contentDescription = "Posters",modifier = Modifier
                  .size(80.dp)
                  .clip(RoundedCornerShape(CornerSize(10.dp)))
                  .padding(8.dp)
                  .align(Alignment.CenterVertically)
                  .weight(2f))
            Text(text = movieLists.tittle, modifier = Modifier
                .padding(8.dp)
                .align(Alignment.CenterVertically)
                .weight(5f))

            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier
                    .align(Alignment.CenterVertically)
                    .weight(1f),
            )
        }
    }
}

@Composable
fun RecyclerView(movieLists: List<MovieDataClass>) {
    LazyColumn(){
        items(movieLists){ movies ->
            EachRow(movieLists = movies)

        }
    }
}

