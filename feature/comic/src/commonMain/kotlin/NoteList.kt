//package com.aicontent.comic.ui.homePage.SearchScreen
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Row
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxWidth
//import androidx.compose.foundation.layout.width
//import androidx.compose.foundation.lazy.LazyColumn
//import androidx.compose.material.Text
//import androidx.compose.material.TextField
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//
//enum class FilterType {
//    NONE,
//    CREATED_DATE,
//    MODIFIED_DATE,
//    TAGS
//}
//
//@Composable
//fun NoteList(
////    notes: List<Note>,
////    onNoteClick: (Note) -> Unit,
////    onSearchQueryChange: (String) -> Unit,
////    onFilterChange: (FilterType) -> Unit
//) {
//    var searchQuery by remember { mutableStateOf("") }
//    var filterType by remember { mutableStateOf(FilterType.NONE) }
//
//    Column {
//        // Search bar
//        TextField(
//            value = searchQuery,
//            onValueChange = {
//                searchQuery = it
////                onSearchQueryChange(it)
//            },
//            label = { Text("Search notes") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
//        // Filter dropdown
//        Row {
//            Text("Filter by:")
//            Spacer(Modifier.width(8.dp))
//            DropdownMenu(
//                expanded = filterType != FilterType.NONE,
//                onDismissRequest = { filterType = FilterType.NONE },
//                modifier = Modifier.width(200.dp)
//            ) {
//                DropdownMenuItem(onClick = { onFilterChange(FilterType.CREATED_DATE) }) {
//                    Text("Created date")
//                }
//                DropdownMenuItem(onClick = { onFilterChange(FilterType.MODIFIED_DATE) }) {
//                    Text("Modified date")
//                }
//                DropdownMenuItem(onClick = { onFilterChange(FilterType.TAGS) }) {
//                    Text("Tags")
//                }
//            }
//        }
//
//        LazyColumn {
//            val filteredNotes = when (filterType) {
//                FilterType.CREATED_DATE -> notes.sortedByDescending { it.createdDate }
//                FilterType.MODIFIED_DATE -> notes.sortedByDescending { it.modifiedDate }
//                FilterType.TAGS -> notes.sortedByDescending { it.tags.size }
//                else -> notes
//            }.filter { it.title.contains(searchQuery, ignoreCase = true) }
//
//            items(filteredNotes) { note ->
//                NoteListItem(note = note, onClick = { onNoteClick(note) })
//            }
//        }
//    }
//}