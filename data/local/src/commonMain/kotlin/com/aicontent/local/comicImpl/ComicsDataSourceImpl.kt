package com.aicontent.local.comicImpl

import com.aicontent.local.ComicBookDatabaseWrapper
import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.local.time.DateTimeUtil
import com.aicontent.local.time.toNote
import com.aicontent.model.comic.local.ComicsEntity
import kotlinx.datetime.LocalDateTime

class ComicsDataSourceImpl(
    databaseWrapper: ComicBookDatabaseWrapper,
//    private val comicsDao: ComicsDataSource,
) : ComicsDataSource {
    private val database = databaseWrapper.instance
    private val dbQuery = database.comicDatabaseQueries

    override suspend fun getAllComics(): List<ComicsEntity> {
        dbQuery.transaction {
            dbQuery.getAllComics()
        }
        return dbQuery.getAllComics().executeAsList().map { it.toNote() }
    }

    override suspend fun insertComics(comic: ComicsEntity) {
        dbQuery.insertNew(
            id = comic.id,
            title = comic.title,
            description = comic.description,
            categoryId = comic.category,
            author = comic.author,
            pageCount = comic.pageCount,
            favorites = comic.favorites,
            created = DateTimeUtil.toEpochMillis(comic.created),
            image = comic.image
        )
    }

    override suspend fun getComicById(id: Long) {
        dbQuery.transaction {
            dbQuery.getComicById(id)
        }
//        return dbQuery.getComicById(id).executeAsOneOrNull()?.toNote()
//        return dbQuery.getComicById(id)
    }

//    override suspend fun getComicById(id: Long): ComicsEntity? {
////        return dbQuery.transactionWithResult {
////            dbQuery.getComicById(id)?.let(::mapComicSelecting)
////        }
//    }

//    override suspend fun getComicById(id: Long): ComicsEntity? {
////        dbQuery.transaction {
////            dbQuery.getComicById(id)
////        }
////        return comicsDao.getComicById(id)
//    }

    override suspend fun deleteComicById(id: Long) {
        dbQuery.transaction {
            dbQuery.deleteComicById(id)
        }
    }

    override suspend fun deleteComics() {
        dbQuery.transaction {
            dbQuery.deleteComics()
        }
    }

    override suspend fun updateComicById(comic: ComicsEntity) {
        dbQuery.transaction {
            comic.id?.let {
                dbQuery.updateComicById(
        //                id = comic.id,
                    title = comic.title,
                    description = comic.description,
                    categoryId = comic.category,
                    author = comic.author,
                    pageCount = comic.pageCount,
                    favorites = comic.favorites,
                    created = DateTimeUtil.toEpochMillis(comic.created),
                    image = comic.image,
                    id = it
                )
            }
        }
    }

//    override suspend fun searchNotes(query: String): List<ComicsEntity> {
//        dbQuery.transaction {
//            dbQuery.searchComic()
//        }
////        val searchQuery = "%$query%"
////        return notesQueries.searchNotes(searchQuery, searchQuery).executeAsList()
////        TODO("Not yet implemented")
//    }
//
//    override suspend fun filterNotesByCategory(categoryId: Long): List<ComicsEntity> {
//        TODO("Not yet implemented")
//    }

    private fun mapComicSelecting(
        id: Long,
        title: String,
        description: String,
        category: String,
        author: String,
        pageCount: Long,
        favourites: Long,
        created: LocalDateTime,
        image: String
    ): ComicsEntity {
        return ComicsEntity(
            id,
            title,
            description,
            category,
            author,
            pageCount,
            favourites,
            created,
            image
        )
    }

}
