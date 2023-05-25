//package com.aicontent.comic.ui.saved
//
//import kotlinx.coroutines.flow.MutableStateFlow
//
//import androidx.compose.animation.ExperimentalAnimationApi
//import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.foundation.lazy.items
//import androidx.compose.material.*
//import androidx.compose.material.icons.Icons
//import androidx.compose.material.icons.filled.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.unit.sp
//import cafe.adriel.voyager.core.model.rememberScreenModel
//import cafe.adriel.voyager.core.registry.rememberScreen
//import cafe.adriel.voyager.core.screen.Screen
//import cafe.adriel.voyager.kodein.rememberScreenModel
//import cafe.adriel.voyager.navigator.LocalNavigator
//import cafe.adriel.voyager.navigator.currentOrThrow
//import com.aicontent.comic.ui.navigation.SharedScreen
//import com.aicontent.local.di.databaseModule
//import com.aicontent.model.comic.local.ComicsEntity
//
////fun main() {
////    val items = listOf(
////        Item(1, "Item 1", "Description 1"),
////        Item(2, "Item 2", "Description 2"),
////        // ... Add more items as needed
////    )
////
////    val itemDetailsScreen = screens[Screen.ItemDetails::class]
////
////    val appNavigator = navigator.startWith(Screen.ItemList)
////    val currentScreen = MutableStateFlow(appNavigator.state)
////    val actions = appNavigator.actions.collectAsState()
////
////    // Compose the app using the current screen state
////    setContent {
////        VoyagerTheme {
////            val currentScreenValue = currentScreen.collectAsState().value
////            val navigateToItemDetails = actions.value.toItemDetails()
////
////            when (currentScreenValue) {
////                Screen.ItemList -> {
////                    ItemListScreen(items = items, onItemClick = navigateToItemDetails)
////                }
////                is Screen.ItemDetails -> {
////                    currentScreenValue.itemDetailsScreen?.invoke(this, currentScreenValue)
////                }
////            }
////        }
////    }
////}
//sealed class HomePageScreen : Screen {
//    object HomePage : HomePageScreen()
//
//    @Composable
//    override fun Content() {
//        val viewModel = rememberScreenModel { HomePageViewModel() }
//        val navigator = LocalNavigator.currentOrThrow
//        val searchScreen = rememberScreen(SharedScreen.SearchScreen)
//        val addScreen = rememberScreen(SharedScreen.AddScreen)
//        val comics by viewModel.comics.collectAsState(emptyList())
//
//        val selectedComic by viewModel.selectedComic.collectAsState(null)
//
//        Scaffold(
//            topBar = { TopBarHomePage { navigator.push(searchScreen) } },
//            backgroundColor = Color.White,
//            floatingActionButton = {
//                FloatingActionButton(
//                    onClick = { navigator.push(addScreen) },
//                    backgroundColor = MaterialTheme.colors.primary
//                ) {
//                    Icon(Icons.Default.Add, contentDescription = "Add")
//                }
//            },
//            floatingActionButtonPosition = FabPosition.End
//        ) {
//            Column {
//                LazyColumn(
//                    modifier = Modifier.padding(16.dp),
//                    contentPadding = PaddingValues(vertical = 8.dp),
//                    verticalArrangement = Arrangement.spacedBy(8.dp),
//                ) {
//                    item {
//                        Row(
//                            horizontalArrangement = Arrangement.SpaceBetween,
//                        ) {
//                            Text("Don't Miss These Comics", fontSize = 24.sp)
//                            Spacer(modifier = Modifier.padding(start = 36.dp))
//                            Button(onClick = { viewModel.deleteComics() }) {
//                                Text("Clear")
//                            }
//                        }
//                    }
//                    items(comics) { comic ->
//                        ItemComics(
//                            comic,
//                            onClick = { viewModel.setSelectedComic(comic); navigator.push(addScreen) },
//                            onDeleteClick = { viewModel.deleteComicById(comic.id!!) }
//                        )
//                    }
//                }
//            }
//        }
//    }
//}
//
//@Composable
//fun TopBarHomePage(onSearchClicked: () -> Unit) {
//    TopAppBar(
//        title = { Text(text = "ComicBooks") },
//        actions = {
//            IconButton(onClick = onSearchClicked) {
//                Icon(Icons.Filled.Search, contentDescription = "Search")
//            }
//            IconButton(onClick = { /* Handle avatar click */ }) {
//                Icon(Icons.Filled.Person, contentDescription = "Avatar")
//            }
//        }
//    )
//}
