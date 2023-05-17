package com.aicontent.local.time

import com.aicontent.model.comic.local.ComicsEntity
import comaicontentdatabase.Comics
import kotlinx.datetime.Instant
import kotlinx.datetime.toLocalDateTime

fun Comics.toNote(): ComicsEntity {
    return ComicsEntity(
        id = id,
        title = title,
        description = description,
        category = categoryId,
        author = author,
        pageCount=  pageCount,
        favorites = favorites,
        created = Instant.fromEpochMilliseconds(created).toLocalDateTime(kotlinx.datetime.TimeZone.currentSystemDefault()),
        image = image
    )
}