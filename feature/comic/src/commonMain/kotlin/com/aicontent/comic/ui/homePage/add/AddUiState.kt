package com.aicontent.comic.ui.homePage.add

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.aicontent.local.time.DateTimeUtil
import kotlinx.datetime.LocalDateTime

class AddUiState(
    id: Long = 0L,
    title: String = "",
    description: String = "",
    category: String = "",
    author: String = "",
    pageCount: Long = 0L,
    isFavorite: Long = 0L,
    created: LocalDateTime = DateTimeUtil.now(),
    image: String = ""
) {
    var id by mutableStateOf(id)
        private set
    var title by mutableStateOf(title)
        private set
    var description by mutableStateOf(description)
        private set
    var category by mutableStateOf(category)
        private set
    var author by mutableStateOf(author)
        private set
    var pageCount by mutableStateOf(pageCount)
        private set
    var favorites by mutableStateOf(isFavorite)
        private set
    var created by mutableStateOf(created)
        private set
    var image by mutableStateOf(image)
        private set

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