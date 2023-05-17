package com.aicontent.model.comic.local

import com.aicontent.model.comic.domain.ComicModel
import com.aicontent.model.Dto
import kotlinx.serialization.Serializable
@Serializable
data class ComicEntity(
    val id: Int,
    val title: String?,
    val author: String?,
    val cover_image: String?,
    val description: String?,
    val release_data: String?
): Dto{
    override fun mapToDomainModel(): ComicModel{
        return ComicModel((id?: Int) as Int,title?:"", author?:"",cover_image?:"",description?:"",release_data?:"")
    }
}