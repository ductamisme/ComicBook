package com.aicontent.domain.comic.repository

import com.aicontent.model.comic.domain.ComicModel

interface ComicRepository {

    suspend fun getPersonById(forceReload: Boolean, peopleId: Int): ComicModel

}