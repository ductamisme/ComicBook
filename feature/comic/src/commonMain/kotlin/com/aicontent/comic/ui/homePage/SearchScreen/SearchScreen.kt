package com.aicontent.comic.ui.homePage.SearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.aicontent.comic.ui.navigation.SharedScreen
import com.aicontent.local.time.DateTimeUtil
import com.aicontent.model.comic.local.ComicsEntity
import com.mangala.wallet.features.people.ui.icons.ArrowBack

class SearchScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { SearchViewModel() }
        val searchQuery = remember { mutableStateOf("") }
        val searchResults by viewModel.searchResults.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        val selectedComic by viewModel.selectedComic.collectAsState(null)

        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
//                    .padding(horizontal = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(56.dp)
                        .background(Color.White, RoundedCornerShape(16.dp))
                ) {
                    TextField(
                        value = searchQuery.value,
                        onValueChange = { query ->
                            searchQuery.value = query
                            viewModel.searchComic(query)
                        },
                        textStyle = TextStyle(color = Color.Black),
                        placeholder = {
                            Text(text = "Search")
                        },
                        modifier = Modifier.fillMaxSize(),
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Search
                        ),
                        keyboardActions = KeyboardActions(
                            onSearch = {
//                        onSearchAction()
                            }
                        ),
                        leadingIcon = {
                            IconButton(
                                onClick = {
                                    navigator.pop()
                                }
                            ) {
                                Icon(
                                    Icons.Default.ArrowBack,
                                    contentDescription = "Back",
                                    tint = Color.Gray
                                )
                            }
                        },
                        trailingIcon = {
                            if (searchQuery.value.isNotEmpty()) {
                                IconButton(
                                    onClick = {
                                        searchQuery.value = ""
                                    }
                                ) {
                                    Icon(
                                        Icons.Default.Clear,
                                        contentDescription = "Clear Icon",
                                        tint = Color.Gray
                                    )
                                }
                            }
                        },
                        singleLine = true,
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color.White,
                            cursorColor = Color.Black,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            if (searchResults.value.isNotEmpty()) {
                LazyColumn(modifier = Modifier.fillMaxSize().padding(8.dp)) {
                    items(searchResults.value) { comic ->
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
                        // Display each search result item
                        ItemComicsSearch(
                            comic,
                        ) { navigator.push(editScreen) }
                    }
                }
            } else {
                Text(
                    text = "No results found",
                    modifier = Modifier.fillMaxWidth().padding(16.dp)
                )
            }
        }
    }
}