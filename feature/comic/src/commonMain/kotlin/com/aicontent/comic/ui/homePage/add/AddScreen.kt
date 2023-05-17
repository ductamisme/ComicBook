package com.aicontent.comic.ui.homePage.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.aicontent.comic.ui.navigation.SharedScreen
import com.aicontent.model.comic.local.ComicsEntity


class AddScreen(): Screen{

    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { AddViewModel() }
//        val hasNoteBeenSaved by viewModel.hasComicBeenSaved.collectAsState()

        val navigator = LocalNavigator.currentOrThrow
        val homePageScreen = rememberScreen(SharedScreen.HomePageScreen)

//        LaunchedEffect(key1 = hasNoteBeenSaved) {
//            if(hasNoteBeenSaved) {
//                navigator.push(homePageScreen)
//            }
//        }
        val uiState = remember { AddUiState() }

        Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
            OutlinedTextField(
                value = uiState.id.toString(),
                onValueChange = { uiState.updateId(it.toLongOrNull() ?: 0)},
                label = { Text("id") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = uiState.title,
                onValueChange = { uiState.updateTitle(it) },
                label = { Text("Title") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = uiState.description,
                onValueChange = { uiState.updateDescription(it) },
                label = { Text("Description") },
                modifier = Modifier.fillMaxWidth()
            )
            OutlinedTextField(
                value = uiState.category,
                onValueChange = { uiState.updateCategory(it) },
                label = { Text("Category") },
                modifier = Modifier.fillMaxWidth()
            )
//            OutlinedTextField(
//                value = uiState.image,
//                onValueChange = { uiState.updateImage(it) },
//                label = { Text("Image") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            OutlinedTextField(
//                value = uiState.author,
//                onValueChange = { uiState.updateAuthor(it) },
//                label = { Text("Author") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            OutlinedTextField(
//                value = uiState.pageCount.toString(),
//                onValueChange = { uiState.updatePageCount(it.toLongOrNull() ?: 0)},
//                label = { Text("pageCount") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            OutlinedTextField(
//                value = uiState.favorites.toString(),
//                onValueChange = { uiState.updateFavorites(it.toLongOrNull() ?: 0)},
//                label = { Text("Favorites") },
//                modifier = Modifier.fillMaxWidth()
//            )
//            OutlinedTextField(
//                value = uiState.created.toString(),
//                onValueChange = { uiState.updateCreate()},
//                label = { Text("id") },
//                modifier = Modifier.fillMaxWidth()
//            )
            Button(
                onClick = {
                    val comic = ComicsEntity(
                        uiState.id,
                        uiState.title,
                        uiState.description,
                        uiState.category,
                        uiState.author,
                        uiState.pageCount,
                        uiState.favorites,
                        uiState.created,
                        uiState.image
                    )
                    viewModel.insertComic(comic)
                    navigator.push(homePageScreen)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Add Comic")
            }
        }
    }
}
