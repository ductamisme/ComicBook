package com.aicontent.remote.comic

import com.aicontent.model.comic.remote.ComicDto

class ComicRemoteDataSource(private val comicApi: ComicApi){
    suspend fun getComicByIdResponse(comicId : Int): ComicDto{
        return comicApi.getComicByIdResponse(comicId)
    }
}