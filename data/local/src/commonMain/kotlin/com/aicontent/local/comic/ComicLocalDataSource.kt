package com.aicontent.local.comic

import com.aicontent.model.comic.local.ComicEntity

interface ComicLocalDataSource {
    fun clearDatabase()
    fun getAllComic(): List<ComicEntity>
    fun createComic(comic: List<ComicEntity>)
}

//open class ComicsRepository(database: MangalaWalletDatabase) {
//    private val comicsQueries = database.comicDatabaseQueries
//
//    fun getAllComics(): List<ComicDatabase> = comicsQueries.selectAllComicInfor().executeAsList()
//}
