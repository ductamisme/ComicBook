package com.aicontent.domain.comic.repository

import com.aicontent.model.comic.local.ComicsEntity

class ComicsRepositoryImpl : ComicsRepository {
    override suspend fun insertComics(comic: ComicsEntity) {

    }

    override suspend fun getAllComics(): List<ComicsEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteComic() {
        TODO("Not yet implemented")
    }
}