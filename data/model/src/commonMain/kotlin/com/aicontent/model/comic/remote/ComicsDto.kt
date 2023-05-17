package com.aicontent.model.comic.remote

import com.aicontent.model.Dto
import com.aicontent.model.comic.domain.ComicsModel
import kotlinx.datetime.LocalDateTime

//@kotlinx.serialization.Serializable
data class ComicsDto(
    val id: Long?,
    val title: String,
    val description: String,
    val category: String,
    val author: String,
    val pageCount: Long,
    val favorites: Long,
    val created: LocalDateTime,
    val image: String,
): Dto {
    override fun mapToDomainModel(): ComicsModel {
        return ComicsModel(id, title, description,category,author,pageCount, favorites, created, image)
    }
}
