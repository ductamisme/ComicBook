package com.aicontent.domain.comic.repository

import com.aicontent.model.comic.domain.ComicModel
import com.aicontent.model.comic.domain.MangaModel

interface ComicRepository {

    suspend fun getComicById(forceReload: Boolean, comicId: Int): ComicModel
}

// free to test
interface MangaRepositoryNew {
    suspend fun getAllManga(forceReload: Boolean): List<MangaModel>

    suspend fun getMangaById(forceReload: Boolean, id: Long): MangaModel

    suspend fun insertManga(comic: MangaModel): MangaModel

    suspend fun deleteMangaById(id: Long): MangaModel
}
