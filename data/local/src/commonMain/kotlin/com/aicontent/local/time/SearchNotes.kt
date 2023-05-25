package com.aicontent.local.time

import com.aicontent.model.comic.local.ComicsEntity

class SearchNotes {
    fun execute(notes: List<ComicsEntity>, query: String): List<ComicsEntity> {
        if(query.isBlank()) {
            return notes
        }
        return notes.filter {
            it.title.trim().lowercase().contains(query.lowercase()) ||
                    it.description.trim().lowercase().contains(query.lowercase())
        }.sortedBy {
            DateTimeUtil.toEpochMillis(it.created)
        }
    }
}