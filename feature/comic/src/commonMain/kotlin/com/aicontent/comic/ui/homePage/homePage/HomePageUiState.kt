package com.aicontent.comic.ui.homePage.homePage

data class HomePageUiState(
    val id: Long = 0,
    val title: String = "",
    val description: String = "",
    val category: Long = 0,
    val pageCount: Long = 0,
    val isFavorite: Boolean = false,
    val isCompleted: Boolean = false
) {
    fun isValid(): Boolean {
        return title.isNotEmpty() && pageCount > 0
    }
}