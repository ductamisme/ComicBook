package com.aicontent.local.comicImpl

import com.aicontent.local.ComicBookDatabaseWrapper
import com.aicontent.local.comic.ComicLocalDataSource
import com.aicontent.model.comic.local.ComicEntity

class ComicLocalDataSourceImpl(
    databaseWrapper: ComicBookDatabaseWrapper,
) : ComicLocalDataSource {
    private val database = databaseWrapper.instance
    private val dbQuery = database.comicDatabaseQueries
    override fun clearDatabase() {
        dbQuery.transaction {
            dbQuery.removeAllComic()
        }
    }

    override fun getAllComic(): List<ComicEntity> {
        TODO("Not yet implemented")
    }

    override fun createComic(comic: List<ComicEntity>) {
        TODO("Not yet implemented")
    }


    private fun mapComicSelecting(
        id: Int,
        title: String?,
        author: String?,
        cover_image: String?,
        description: String?,
        release_data: String?
    ): ComicEntity {
        return ComicEntity(
            id, title, author, cover_image, description, release_data
        )
    }

//    override fun createComic(comic: List<ComicEntity>) {
//        dbQuery.transaction {
//            comic.forEach { comic ->
//                insertComic(comic)
//            }
//        }
//    }
//
//    private fun insertComic(comic: ComicEntity) {
//        dbQuery.insertComic(
//            comic.book,
//            comic.author,
//            comic.content
//        )
//    }

}