package com.aicontent.model.comic.domain

import com.aicontent.model.comic.local.ComicEntity
import com.aicontent.model.comic.remote.ComicDto
import com.aicontent.model.Model
import kotlinx.serialization.Serializable


@Serializable
data class ComicModel(
    val id: Int,
    val title: String,
    val author: String,
    val cover_image: String,
    val description: String,
    val release_data: String
): Model{
    override fun toLocalDto(): ComicEntity{
        return ComicEntity(id, title, author, cover_image, description, release_data)
    }

    override fun toRemoteDto(): ComicDto{
        return ComicDto(id, title, author, cover_image, description, release_data)
    }
}
