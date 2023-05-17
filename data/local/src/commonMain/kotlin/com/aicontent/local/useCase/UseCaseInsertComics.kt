package com.aicontent.local.useCase

import com.aicontent.local.time.DateTimeUtil
import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class UseCaseInsertComics(private val dataSource: ComicsDataSource) {

//    var _hasBeenSaved = MutableStateFlow(false)

//    val uiState: StateFlow<AuthorScreenUiState> = …

//    val addUiState : MutableStateFlow<AddUiState>()

    @OptIn(DelicateCoroutinesApi::class)
    fun insertComic(comic: ComicsEntity) {
        kotlinx.coroutines.GlobalScope.launch {
            dataSource.insertComics(
                ComicsEntity(
                    id = comic.id,
                    title = comic.title,
                    description = comic.description,
                    category = comic.category,
                    author = comic.author,
                    pageCount = comic.pageCount,
                    favorites = comic.favorites,
                    created = DateTimeUtil.now(),
                    image = comic.image
                )
            )
//            _hasBeenSaved.value = true
        }
    }
}