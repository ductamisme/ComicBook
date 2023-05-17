package com.aicontent.model.comic.remote

import com.aicontent.model.Dto
import com.aicontent.model.comic.domain.ComicModel
import com.aicontent.model.comic.domain.MangaModel
import kotlinx.serialization.Serializable

@Serializable
data class MangaDto(
    val id: Int,
    val title: String,
    val author: String,
//    val cover_image: String,
//    val description: String,
//    val release_data: String
) : Dto {
    override fun mapToDomainModel(): MangaModel {
        return MangaModel((id?: Int) as Int,title?:"", author?:"")
    }
}