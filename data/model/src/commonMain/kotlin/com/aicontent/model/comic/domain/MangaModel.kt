package com.aicontent.model.comic.domain

import com.aicontent.model.Model
import com.aicontent.model.comic.local.ComicEntity
import com.aicontent.model.comic.local.MangaEntity
import com.aicontent.model.comic.remote.ComicDto
import com.aicontent.model.comic.remote.MangaDto
import kotlinx.serialization.Serializable

@Serializable
data class MangaModel(
    val id: Int,
    val title: String,
    val author: String,
//    val cover_image: String,
//    val description: String,
//    val release_data: String
): Model {
    override fun toLocalDto(): MangaEntity {
        return MangaEntity(id, title, author)
    }

    override fun toRemoteDto(): MangaDto {
        return MangaDto(id, title, author)
    }
}