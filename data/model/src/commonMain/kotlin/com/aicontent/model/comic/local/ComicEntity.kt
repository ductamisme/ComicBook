package com.aicontent.model.comic.local

import com.aicontent.model.comic.domain.ComicModel
import com.aicontent.model.Dto
import kotlinx.serialization.Serializable
@Serializable
data class ComicEntity(
    val book: String,
    val author: String,
    val content: String,
): Dto{
    override fun mapToDomainModel(): ComicModel{
        return ComicModel(book?:"",author?:"", content?:"")
    }
}