package com.aicontent.comic.ui.topics

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.aicontent.comic.ui.homePage.homePage.HomePageViewModel
import com.aicontent.comic.ui.navigation.SharedScreen

sealed class IconType {
    object Comic : IconType()
    object Upvote : IconType()
    object Comment : IconType()
    object Save : IconType()
    object Star : IconType()
    object Schedule : IconType()
    object Add : IconType()
    object Delete : IconType()
}

class TopicsScreen : Screen {
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { HomePageViewModel() }
        val navigator = LocalNavigator.currentOrThrow
        val savedScreen = rememberScreen(SharedScreen.AddScreen)
        val comics by viewModel.comics.collectAsState(emptyList())

        Scaffold(
            topBar = { TopBarHomePage() }, backgroundColor = Color.White,
        ) {
            LazyRow(
                modifier = Modifier.padding(start = 24.dp, end = 24.dp).scale(1f),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                items(comics) { comic ->
                    HotItems(
                        modifier = Modifier,
                        comic.title,
                        comic.category,
//                            comic.image
                        "https://upload.wikimedia.org/wikipedia/vi/c/c6/HocvienanhhungNhiemvugiaicuuthegioi.jpeg"
                    )
                }
            }
        }
    }
}


@Composable
fun TopBarHomePage() {
    TopAppBar(
        title = { Text(text = "ComicBooks") },
        actions = {
            IconButton(onClick = { /* Handle search click */ }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /* Handle avatar click */ }) {
                Icon(Icons.Filled.Person, contentDescription = "Avatar")
            }
        }
    )
}


