package com.aicontent.local.useCase

import com.aicontent.local.comic.ComicsDataSource
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UseCaseDeleteById(private val dataSource: ComicsDataSource) {
    @OptIn(DelicateCoroutinesApi::class)
    fun deleteComic(loadComics:Unit, id: Long) {
        kotlinx.coroutines.GlobalScope.launch {
            withContext(Dispatchers.Main) {
                dataSource.deleteComicById(id)
            }
            loadComics
        }
    }
}