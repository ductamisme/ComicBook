package com.aicontent.local.useCase

import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UseCaseUpdateComicById(private val dataSource: ComicsDataSource) {
    @OptIn(DelicateCoroutinesApi::class)
    fun updateComicById(comicsEntity: ComicsEntity, loadComics: Unit) {
        kotlinx.coroutines.GlobalScope.launch {
            withContext(Dispatchers.Main) {
//                    dataSource.getComicById()
                dataSource.updateComicById(comicsEntity)
            }
            loadComics
//            notesRepository.updateNoteById(note)
        }
    }
}