package com.aicontent.comic.ui.homePage.homePage

import cafe.adriel.voyager.core.model.ScreenModel
import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.local.useCase.UseCaseDeleteAllNote
import com.aicontent.local.useCase.UseCaseDeleteById
import com.aicontent.local.useCase.UseCaseGetComicById
import com.aicontent.local.useCase.UseCaseGetAllComics
import com.aicontent.local.useCase.UseCaseUpdateComicById
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import org.brightify.hyperdrive.multiplatformx.BaseViewModel
import org.koin.core.component.KoinComponent
//import org.koin.android.ext.android.inject
import org.koin.core.component.inject

class HomePageViewModel : BaseViewModel(), ScreenModel, KoinComponent {


    private val useCaseUpdateComicById: UseCaseUpdateComicById by inject()
    private val useCaseDeleteAllNote: UseCaseDeleteAllNote by inject()
    private val useCaseGetAllComics: UseCaseGetAllComics by inject()
    private val useCaseDeleteById: UseCaseDeleteById by inject()
    private val useCaseGetComicById: UseCaseGetComicById by inject()

    private val _comics = useCaseGetAllComics.comicState
    val comics: StateFlow<List<ComicsEntity>> = _comics.asStateFlow()

//    private val _comics = MutableStateFlow<List<ComicsEntity>>(emptyList())
//    val comics: StateFlow<List<ComicsEntity>> = _comics.asStateFlow()

    private val _selectedNote = MutableStateFlow<ComicsEntity?>(null)
    val selectedNote: StateFlow<ComicsEntity?> = _selectedNote.asStateFlow()

    fun setSelectedNote(Comic: ComicsEntity) {
        _selectedNote.value = Comic
    }

    fun resetSelectedNote() {
        _selectedNote.value = null
    }

//
//    fun setSelectedNote(note: ComicsEntity) {
//        _selectedNote = note
//    }
//
//    fun resetSelectedNote() {
//        _selectedNote = null
//    }

    init {
        loadComics()
    }

    fun updateNoteById(comicsEntity: ComicsEntity) {
        useCaseUpdateComicById.updateComicById(
            comicsEntity, loadComics()
        )
    }

    fun deleteComicById(id: Long) {
        useCaseDeleteById.deleteComic(loadComics(), id)
    }

    fun deleteComics() {
        useCaseDeleteAllNote.deleteComic(loadComics())
    }

    suspend fun getComicById(id: Long) {
        return useCaseGetComicById.getComicById(id)
    }

    private fun loadComics() {
        useCaseGetAllComics.loadComics()
    }

    class Factory(private val dataSource: ComicsDataSource) {
        fun create() = HomePageViewModel()
    }
}