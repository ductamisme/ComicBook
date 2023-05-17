package com.aicontent.comic.ui.homePage.homePage

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.aicontent.comic.ui.navigation.SharedScreen

class SearchScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val addScreen = rememberScreen(SharedScreen.AddScreen)
        var searchText by remember { mutableStateOf("") }

        Scaffold(
            topBar = { SearchBar(searchText = searchText, onTextChanged = { searchText = it }, {navigator.pop()})  }
        ) {
            // Add your search result list here
            Text("Search results for '$searchText'")
        }
    }
}

@Composable
fun SearchBar(searchText: String, onTextChanged: (String) -> Unit, onClick: () -> Unit) {
    TopAppBar(
        title = {
            Box(Modifier.fillMaxWidth()) {
                TextField(
                    value = searchText,
                    onValueChange = onTextChanged,
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Search") },
                    leadingIcon = {
                        Icon(Icons.Default.Search, contentDescription = "Search")
                    },
                    trailingIcon = {
                        if (searchText.isNotEmpty()) {
                            IconButton(onClick = { onTextChanged("") }) {
                                Icon(Icons.Default.Clear, contentDescription = "Clear")
                            }
                        }
                    },
//                    colors = TextFieldDefaults.textFieldColors(
//                        backgroundColor = MaterialTheme.colors.surface,
//                        focusedIndicatorColor = Color.Transparent,
//                        unfocusedIndicatorColor = Color.Transparent
//                    ),
                    textStyle = MaterialTheme.typography.body1,
                    singleLine = true,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = androidx.compose.ui.text.input.ImeAction.Search
                    ),
                    keyboardActions = KeyboardActions(onSearch = { /* Handle search click */ })
                )
            }
        },
        actions = {
//            IconButton(onClick = { /* Handle back click */ }) {
//                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            Button(onClick = {
                onClick()
            }) {
                Text("Return")
            }
        }
    )
}

