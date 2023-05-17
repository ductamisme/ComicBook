package com.aicontent.local.comic

import com.aicontent.model.comic.local.ComicsEntity

interface ComicsDataSource {
    suspend fun insertComics(comic: ComicsEntity)
    suspend fun getComicById(id: Long)
    suspend fun getAllComics(): List<ComicsEntity>
    suspend fun deleteComicById(id: Long)
    suspend fun deleteComics()
    suspend fun updateComicById(comic: ComicsEntity)
}