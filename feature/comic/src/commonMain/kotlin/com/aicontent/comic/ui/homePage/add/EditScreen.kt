package com.aicontent.comic.ui.homePage.add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.aicontent.comic.ui.navigation.SharedScreen
import com.aicontent.local.time.DateTimeUtil
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.datetime.LocalDateTime

class EditScreen(private val comic: ComicsEntity) : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { EditViewModel() }
        val navigator = LocalNavigator.currentOrThrow
        val homePageScreen = rememberScreen(SharedScreen.HomePageScreen)

        val uiState = remember { EditUiState(comic) }

        Column(modifier = Modifier.fillMaxSize().padding(8.dp)) {
//            OutlinedTextField(
//                value = uiState.id.toString(),
//                onValueChange = { uiState.updateId(it.toLongOrNull() ?: 0) },
//                label = { Text("ID") },
//                modifier = Modifier.fillMaxWidth()
//            )
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

            Button(
                onClick = {
                    val updatedComic = ComicsEntity(
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
                    viewModel.updateComic(updatedComic)
                    navigator.push(homePageScreen)
                },
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Text("Update Comic")
            }
        }
    }
}

class EditUiState(comic: ComicsEntity) {
    var id by mutableStateOf(comic.id)
    var title by mutableStateOf(comic.title)
    var description by mutableStateOf(comic.description)
    var category by mutableStateOf(comic.category)
    var author by mutableStateOf(comic.author)
    var pageCount by mutableStateOf(comic.pageCount)
    var favorites by mutableStateOf(comic.favorites)
    var created by mutableStateOf(comic.created)
    var image by mutableStateOf(comic.image)

    fun updateId(newId: Long) {
        id = newId
    }

    fun updateTitle(newTitle: String) {
        title = newTitle
    }

    fun updateDescription(newDescription: String) {
        description = newDescription
    }

    fun updateCategory(newCategory: String) {
        category = newCategory
    }

    fun updateAuthor(newAuthor: String) {
        author = newAuthor
    }
    fun updatePageCount(newPageCount: Long) {
        pageCount = newPageCount
    }

    fun updateFavorites(newIsFavorite: Long) {
        favorites = newIsFavorite
    }

    fun updateCreate() {
//        created = newIsCompleted
    }

    fun updateImage(newImage: String) {
        image = newImage
    }
}
