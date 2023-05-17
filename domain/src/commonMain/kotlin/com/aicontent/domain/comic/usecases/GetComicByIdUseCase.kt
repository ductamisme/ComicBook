package com.aicontent.domain.comic.usecases

import com.aicontent.domain.base.UseCase
import com.aicontent.domain.comic.repository.ComicRepository
import com.aicontent.domain.comic.repository.MangaRepositoryNew
import com.aicontent.model.comic.domain.ComicModel
import com.aicontent.model.comic.domain.MangaModel

class GetComicByIdUseCase(private val comicRepository: ComicRepository):
    UseCase<ComicModel>(){
        override suspend fun run(params: Map<String, Any?>):ComicModel{

            val forceReload = params["forceReload"] as Boolean
            val comicId = params["comicId"] as Int

            return comicRepository.getComicById(forceReload, comicId)
        }
}
