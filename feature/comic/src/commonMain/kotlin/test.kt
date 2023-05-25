//package com.aicontent.comic.ui.Notification
//
//import androidx.compose.foundation.layout.*
////import androidx.compose.foundation.layout.ColumnScopeInstance.weight
//import androidx.compose.material.*
//import androidx.compose.runtime.*
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.unit.dp
//import cafe.adriel.voyager.navigator.Navigator
//import com.aicontent.comic.ui.homePage.homePage.HomePageViewModel
//import com.aicontent.model.comic.local.ComicsEntity
//
////class com.aicontent.comic.ui.homePage.add.EditScreen : Screen {
////    @Composable
////    override fun Content() {
//
// a"Title") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = description,
//            onValueChange = { it },
//            label = { Text("Description") },
//            modifier = Modifier.fillMaxWidth()
//        )
//        OutlinedTextField(
//            value = category,
//            onValueChange = { it },
//            label = { Text("Category") },
//            modifier = Modifier.fillMaxWidth()
//        )
//
////        OutlinedTextField(
////            value = uiState.title,
////
////            onValueChange = {  },
////            label = { "Title" },
////            modifier = Modifier.fillMaxWidth()
////        )
////        OutlinedTextField(
////            value = uiState.description,
////            onValueChange = { uiState.updateDescription(it) },
////            label = { Text("Text") },
////            modifier = Modifier.fillMaxWidth()
////        )
////        OutlinedTextField(
////            value = uiState.category,
////            onValueChange = { uiState.updateCategory(it) },
////            label = { Text("Text") },
////            modifier = Modifier.fillMaxWidth()
////        )
//        Row(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalArrangement = Arrangement.End
//        ) {
//            Button(
//                onClick = {
//                    val updatedNote = ComicsEntity(
//                        id,
//                        title,
//                        description,
//                        category,
//                        author,
//                        pageCount,
//                        favourites,
//                        created,
//                        image
////                        uiState.id,
////                        uiState.title,
////                        uiState.description,
////                        uiState.category,
////                        uiState.author,
////                        uiState.pageCount,
////                        uiState.favorites,
////                        uiState.created,
////                        uiState.image
//                    )
//                    viewModel.updateNoteById(updatedNote)
//                    viewModel.setSelectedNote(updatedNote)
//                },
//                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp, end = 8.dp)
//            ) {
//                Text("Save")
//            }
//            Button(
//                onClick = {
//                    viewModel.resetSelectedNote()
//                },
//                modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
//            ) {
//                Text("Cancel")
//            }
//        }
//    }
//}
//
//
//class com.aicontent.comic.ui.homePage.add.EditUiState(
////    id: Long = 0L,
////    title: String = "",
////    description: String = "",
////    category: String = "",
////    author: String = "",
////    pageCount: Long = 0L,
////    favorite: Long = 0L,
////    created: LocalDateTime = DateTimeUtil.now(),
////    image: String = ""
//    comic: ComicsEntity
//) {
//    var id by mutableStateOf(comic.id)
//        private set
//    var title by mutableStateOf(comic.title)
//        private set
//    var description by mutableStateOf(comic.description)
//        private set
//    var category by mutableStateOf(comic.category)
//        private set
//    var author by mutableStateOf(comic.author)
//        private set
//    var pageCount by mutableStateOf(comic.pageCount)
//        private set
//    var favorites by mutableStateOf(comic.favorites)
//        private set
//    var created by mutableStateOf(comic.created)
//        private set
//    var image by mutableStateOf(comic.image)
//        private set
//
//    fun updateId(newId: Long) {
//        id = newId
//    }
//
//    fun updateTitle(newTitle: String) {
//        title = newTitle
//    }
//
//    fun updateDescription(newDescription: String) {
//        description = newDescription
//    }
//
//    fun updateCategory(newCategory: String) {
//        category = newCategory
//    }
//
//    fun updateAuthor(newAuthor: String) {
//        author = newAuthor
//    }
//
//    fun updatePageCount(newPageCount: Long) {
//        pageCount = newPageCount
//    }
//
//    fun updateFavorites(newIsFavorite: Long) {
//        favorites = newIsFavorite
//    }
//
//    fun updateCreate() {
////        created = newIsCompleted
//    }
//
//    fun updateImage(newImage: String) {
//        image = newImage
//    }
//}
