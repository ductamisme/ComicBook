package com.aicontent.comic.ui.homePage.add

import cafe.adriel.voyager.core.model.ScreenModel
import com.aicontent.local.useCase.UseCaseInsertComics
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class AddViewModel(
) : ScreenModel, KoinComponent {
    private val useCaseInsertComics: UseCaseInsertComics by inject()

//    val _hasComicBeenSaved = useCaseInsertComics._hasBeenSaved
//    val hasComicBeenSaved = _hasComicBeenSaved.asStateFlow()

    fun insertComic(comic: ComicsEntity) {
        useCaseInsertComics.insertComic(comic)
    }
}