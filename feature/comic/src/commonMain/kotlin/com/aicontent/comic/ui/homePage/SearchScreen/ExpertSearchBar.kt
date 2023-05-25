package com.aicontent.comic.ui.homePage.SearchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.ImeAction
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp

@Composable
fun ExpertSearchBar(
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit
//    onSearchAction: () -> Unit,
//    onClearAction: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Search Input Field
        Box(
            modifier = Modifier
                .weight(1f)
                .height(56.dp)
                .background(Color.White, RoundedCornerShape(16.dp))
        ) {
            TextField(
                value = searchQuery,
                onValueChange = onSearchQueryChange,
                textStyle = TextStyle(color = Color.Black),
                placeholder = {
                    Text(text = "Search")
                },
                modifier = Modifier.fillMaxSize(),
                keyboardOptions = KeyboardOptions(
                    imeAction = androidx.compose.ui.text.input.ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
//                        onSearchAction()
                    }
                ),
                leadingIcon = {
                    Icon(
                        Icons.Default.Search,
                        contentDescription = "Search Icon",
                        tint = Color.Gray
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(
                            onClick = {
//                                onClearAction()
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
                singleLine = true
            )
        }

        // Search Suggestion Dropdown
        // we need extend lib
//        DropdownMenu(
//            expanded = searchSuggestions.isNotEmpty(),
//            onDismissRequest = { /* Dismiss the dropdown */ },
//            modifier = Modifier
//                .width(240.dp)
//                .padding(start = 4.dp)
//        ) {
//            searchSuggestions.forEach { suggestion ->
//                DropdownMenuItem(onClick = {
//                    onSearchQueryChange(suggestion)
//                    onSearchAction()
//                }) {
//                    Text(text = suggestion)
//                }
//            }
//        }
    }
}
