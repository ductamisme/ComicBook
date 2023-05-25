package com.aicontent.comic.ui.saved

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemListScreen(items: List<Item>, onItemClick: (Item) -> Unit) {
    Column {
        Text("Item List")
        LazyColumn {
            items(items) { item ->
                ListItem(item = item, onClick = { onItemClick(item) })
            }
        }
    }
}

@Composable
fun ListItem(item: Item, onClick: () -> Unit) {
    Row(
        modifier = Modifier.clickable { onClick() },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Display item details
        Text(text = item.name)
        Text(text = item.description)
    }
}

@Composable
fun ItemDetailsScreen(item: Item) {
    Column {
        Text("Item Details")
        // Display item details
        Text(text = item.name)
        Text(text = item.description)
    }
}
