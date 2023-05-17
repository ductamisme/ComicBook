package com.aicontent.domain.comic.repository

import com.aicontent.local.comic.ComicLocalDataSource
import com.aicontent.model.comic.domain.ComicModel
import com.aicontent.model.comic.local.ComicEntity
import com.aicontent.remote.comic.ComicRemoteDataSource

class ComicRepositoryImpl(private val network: ComicRemoteDataSource, private val local: ComicLocalDataSource):
    ComicRepository {
    override suspend fun getComicById(forceReload: Boolean, comicId: Int): ComicModel {
        val cachedComics = local.getAllComic()
        return if (cachedComics.isNotEmpty() && !forceReload) {
            cachedComics[0].mapToDomainModel()
        } else {
            val comicDto = network.getComicByIdResponse(comicId)
            val comicModel = comicDto.mapToDomainModel()

            local.clearDatabase()
            val listPeople = mutableListOf<ComicEntity>()
            listPeople.add(comicModel.toLocalDto())
            local.createComic(listPeople)

            comicModel
        }
    }

}