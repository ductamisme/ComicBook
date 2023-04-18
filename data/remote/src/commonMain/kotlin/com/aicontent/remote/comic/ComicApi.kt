package com.aicontent.remote.comic

import com.aicontent.model.comic.remote.ComicDto
import de.jensklingenberg.ktorfit.http.GET
import de.jensklingenberg.ktorfit.http.Path

interface ComicApi {
    @GET("comic/{id}")
    suspend fun getComicByIdResponse(@Path("id") comicId: Int): ComicDto
}