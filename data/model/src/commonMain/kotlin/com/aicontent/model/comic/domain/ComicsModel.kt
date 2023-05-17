package com.aicontent.model.comic.domain

import com.aicontent.model.Model
import com.aicontent.model.comic.local.ComicsEntity
import com.aicontent.model.comic.remote.ComicsDto
import kotlinx.datetime.LocalDateTime

data class ComicsModel(
    val id: Long?,
    val title: String,
    val description: String,
    val category: String,
    val author: String,
    val pageCount: Long,
    val favorites: Long,
    val created: LocalDateTime,
    val image: String,
//    val tags: List<Tag>,
//    val category: Category
): Model {
    override fun toLocalDto(): ComicsEntity {
        return ComicsEntity(id, title, description,category,author,pageCount, favorites, created, image)
    }

    override fun toRemoteDto(): ComicsDto {
        return ComicsDto(id, title, description,category,author,pageCount, favorites, created, image)
    }
}

