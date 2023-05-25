package com.aicontent.comic.ui.homePage.add

import cafe.adriel.voyager.core.model.ScreenModel
import com.aicontent.local.useCase.UseCaseGetAllComics
import com.aicontent.local.useCase.UseCaseInsertComics
import com.aicontent.local.useCase.UseCaseUpdateComicById
import com.aicontent.model.comic.local.ComicsEntity
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class EditViewModel() : ScreenModel, KoinComponent {
    private val useCaseUpdateComicById: UseCaseUpdateComicById by inject()
    private val useCaseGetAllComics: UseCaseGetAllComics by inject()
//    val _hasComicBeenSaved = useCaseInsertComics._hasBeenSaved
//    val hasComicBeenSaved = _hasComicBeenSaved.asStateFlow()

    fun updateComic(comic: ComicsEntity) {
        useCaseUpdateComicById.updateComicById(comic, useCaseGetAllComics.loadComics())
    }
}