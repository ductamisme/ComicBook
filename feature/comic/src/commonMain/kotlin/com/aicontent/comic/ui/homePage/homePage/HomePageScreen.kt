package com.aicontent.comic.ui.homePage.homePage

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.aicontent.comic.ui.ImageItem
import com.aicontent.comic.ui.navigation.SharedScreen
import com.aicontent.local.time.DateTimeUtil
import com.aicontent.model.comic.local.ComicsEntity
import org.koin.core.KoinApplication.Companion.init


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

class HomePageScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { HomePageViewModel() }
        val navigator = LocalNavigator.currentOrThrow
        val searchScreen = rememberScreen(SharedScreen.SearchScreen)
        val comics by viewModel.comics.collectAsState(emptyList())
        val selectedComic by viewModel.selectedComic.collectAsState(null)
        val addScreen = rememberScreen(SharedScreen.AddScreen)
        val avatarScreen = rememberScreen(SharedScreen.AvatarScreen)

        // Reload items when navigation occurs
        LaunchedEffect(navigator) {
            viewModel.loadComics() // Load comics when navigating to this screen
        }

        Scaffold(
            topBar = {
                TopBarHomePage(
                    { navigator.push(searchScreen) },
                    { navigator.push(avatarScreen) })
            },
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
                        val editScreen = rememberScreen(
                            SharedScreen.EditScreen(
                                selectedComic ?: ComicsEntity(
                                    comic.id,
                                    comic.title,
                                    comic.description,
                                    comic.category,
                                    comic.author,
                                    comic.pageCount,
                                    comic.favorites,
                                    DateTimeUtil.now(),
                                    comic.image
                                )
                            )
                        )
                        ItemComics(
                            comic,
                            { navigator.push(editScreen) },
                            { viewModel.deleteComicById(comic.id!!) }
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun TopBarHomePage(onSearchClicked: () -> Unit, onAvatarClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "ComicBooks") },
        actions = {
            IconButton(onClick = onSearchClicked) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
            IconButton(onClick = onAvatarClick) {
                ImageItem(
                    "https://ecdn.game4v.com/g4v-content/uploads/2022/09/25083529/Gojo-2-game4v-1664069728-55.jpg",
                    modifier = Modifier.size(36.dp)
                        .clip(CircleShape)
                )
//                Icon(Icons.Filled.Person, contentDescription = "Avatar")
            }
        }
    )
}


//@Composable
//fun DropdownDemo() {
//    var expanded by remember { mutableStateOf(false) }
//    val items = listOf("A", "B", "C", "D", "E", "F")
//    val disabledValue = "B"
//    var selectedIndex by remember { mutableStateOf(0) }
//    Box(modifier = Modifier.fillMaxSize().wrapContentSize(Alignment.TopStart)) {
//        Text(items[selectedIndex],modifier = Modifier.fillMaxWidth().clickable(onClick = { expanded = true }).background(
//            Color.Gray))
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false },
//            modifier = Modifier.fillMaxWidth().background(
//                Color.Red)
//        ) {
//            items.forEachIndexed { index, s ->
//                DropdownMenuItem(onClick = {
//                    selectedIndex = index
//                    expanded = false
//                }) {
//                    val disabledText = if (s == disabledValue) {
//                        " (Disabled)"
//                    } else {
//                        ""
//                    }
//                    Text(text = s + disabledText)
//                }
//            }
//        }
//    }
//}


