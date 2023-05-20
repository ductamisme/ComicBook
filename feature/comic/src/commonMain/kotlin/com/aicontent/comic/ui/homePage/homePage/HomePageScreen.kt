package com.aicontent.comic.ui.homePage.homePage

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.layout.ColumnScopeInstance.weight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.aicontent.comic.ui.navigation.SharedScreen
import com.aicontent.local.di.databaseModule
import com.aicontent.model.comic.local.ComicsEntity


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

class HomePageScreen() : Screen {
    @OptIn(ExperimentalAnimationApi::class)
    @Composable
    override fun Content() {

        val viewModel = rememberScreenModel { HomePageViewModel() }
        val navigator = LocalNavigator.currentOrThrow
        val searchScreen = rememberScreen(SharedScreen.SearchScreen)
        val addScreen = rememberScreen(SharedScreen.AddScreen)
        val comics by viewModel.comics.collectAsState(emptyList())

        val selectedNote by viewModel.selectedNote.collectAsState(null)

        Scaffold(
            topBar = { TopBarHomePage { navigator.push(searchScreen) } },
            backgroundColor = Color.White,
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator.push(addScreen)
                    },
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            },
            floatingActionButtonPosition = FabPosition.End
        ) {

            val onNoteClicked = { comic: ComicsEntity ->
                viewModel.setSelectedNote(comic)
                navigator.push(addScreen)
            }

//            if (selectedNote != null) {
//                val editScreen = rememberScreen(SharedScreen.EditScreen)
//                EditNoteScreen(
//                    noteId = selectedNote!!.id,
//                    viewModel = viewModel,
//                    navigator = navigator
//                )
//            } else {
            Column {
                LazyColumn(
                    modifier = Modifier.padding(16.dp),
                    contentPadding = PaddingValues(vertical = 8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    item {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                        ) {
                            Text("Don't Miss These Comics", fontSize = 24.sp)
                            Spacer(modifier = Modifier.padding(start = 36.dp))
                            Button(onClick = { viewModel.deleteComics() }) {
                                Text("Clear")
                            }
                        }
                    }
                    items(comics) { comic ->
                        ItemComics(
                            comic,
                            { onNoteClicked(comic) },
                            { viewModel.deleteComicById(comic.id!!) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TopBarHomePage(onSearchClicked: () -> Unit) {
    TopAppBar(
        title = { Text(text = "ComicBooks") },
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = { /* Handle avatar click */ }) {
                Icon(Icons.Filled.Person, contentDescription = "Avatar")
            }
        }
    )
}



