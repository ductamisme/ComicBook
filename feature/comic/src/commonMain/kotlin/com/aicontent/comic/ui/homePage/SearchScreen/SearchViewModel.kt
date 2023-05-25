package com.aicontent.comic.ui.homePage.SearchScreen

import cafe.adriel.voyager.core.model.ScreenModel
import com.aicontent.local.useCase.UseCaseSearchComic
//import com.aicontent.local.useCase.UseCaseSearchComic
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.asStateFlow

class SearchViewModel() : ScreenModel, KoinComponent {

    private val useCaseSearchComic: UseCaseSearchComic by inject()
    private val _searchResults = useCaseSearchComic.searchResults
    private val _searchResultsFlow = MutableStateFlow(_searchResults)

    // copy form HomeViewModel
    private val _selectedComic = MutableStateFlow<ComicsEntity?>(null)
    val selectedComic: StateFlow<ComicsEntity?> = _selectedComic.asStateFlow()


    val searchResults: MutableStateFlow<StateFlow<List<ComicsEntity>>> = _searchResultsFlow


    @OptIn(DelicateCoroutinesApi::class)
    fun searchComic(query: String) {
        useCaseSearchComic.searchComic(query)
    }
}
