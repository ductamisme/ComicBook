package com.aicontent.local.useCase

import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UseCaseGetComicById(private val dataSource: ComicsDataSource) {

    @OptIn(DelicateCoroutinesApi::class)
    suspend fun getComicById(id:Long) {
        kotlinx.coroutines.GlobalScope.launch {
            withContext(Dispatchers.Main) {
                dataSource.getComicById(id)
            }
        }
//        return dataSource.getComicById(id)
    }
}