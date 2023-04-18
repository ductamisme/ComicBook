package com.aicontent.model.comic.remote

import com.aicontent.model.comic.domain.ComicModel
import com.aicontent.model.Dto
import kotlinx.serialization.Serializable
@Serializable
data class ComicDto(
    val book: String,
    val author: String,
    val content: String
): Dto {
    override fun mapToDomainModel(): ComicModel {
        return ComicModel(book?:"",author?:"", content?:"")
    }
}