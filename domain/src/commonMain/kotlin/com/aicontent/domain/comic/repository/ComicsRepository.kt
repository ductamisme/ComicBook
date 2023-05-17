package com.aicontent.domain.comic.repository

import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.model.comic.local.ComicsEntity

interface ComicsRepository {
    suspend fun insertComics(comic: ComicsEntity)
    //    suspend fun getComicById(id: Long): ComicsEntity?
    suspend fun getAllComics(): List<ComicsEntity>
    suspend fun deleteComic()
}