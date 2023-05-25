package com.aicontent.local.useCase

import androidx.compose.runtime.mutableStateListOf
import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.local.time.SearchNotes
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UseCaseSearchComic(private val dataSource: ComicsDataSource) {
    private val _searchResults = mutableStateListOf<ComicsEntity>()
    private val _searchResultsFlow = MutableStateFlow(_searchResults.toList())
    val searchResults: StateFlow<List<ComicsEntity>> get() = _searchResultsFlow

    @OptIn(DelicateCoroutinesApi::class)
    fun searchComic(query: String) {
        if (query.isBlank()) {
            _searchResults.clear()
            return
        }
        GlobalScope.launch(Dispatchers.Main) {
            try {
                val allComics = dataSource.getAllComics()
                val filteredComics = SearchNotes().execute(allComics, query)
                _searchResults.clear()
                _searchResults.addAll(filteredComics)
                _searchResultsFlow.value = _searchResults.toList()
            } catch (e: Exception) {
                // Handle the exception accordingly (e.g., log, display error message)
                e.printStackTrace()
            }
        }
    }
}