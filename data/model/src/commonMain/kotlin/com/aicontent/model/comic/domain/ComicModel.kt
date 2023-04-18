package com.aicontent.model.comic.domain

import com.aicontent.model.comic.local.ComicEntity
import com.aicontent.model.comic.remote.ComicDto
import com.aicontent.model.Model
import kotlinx.serialization.Serializable

@Serializable
data class ComicModel(
    val book: String,
    val author: String,
    val content : String,
): Model{
    override fun toLocalDto(): ComicEntity{
        return ComicEntity(book, author, content)
    }

    override fun toRemoteDto(): ComicDto{
        return ComicDto(book, author, content)
    }
}
