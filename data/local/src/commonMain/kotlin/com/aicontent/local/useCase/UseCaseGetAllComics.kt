package com.aicontent.local.useCase

import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UseCaseGetAllComics(private val dataSource : ComicsDataSource) {

    val comicState: MutableStateFlow<List<ComicsEntity>> = MutableStateFlow(listOf())

    @OptIn(DelicateCoroutinesApi::class)
    fun loadComics() {
        kotlinx.coroutines.GlobalScope.launch {
            val comics = withContext(Dispatchers.Main) {
                dataSource.getAllComics()
            }
            comicState.value = comics
        }
    }
}