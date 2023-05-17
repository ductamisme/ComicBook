package com.aicontent.domain.comic.usecases

import com.aicontent.domain.base.UseCase
import com.aicontent.domain.comic.repository.MangaRepositoryNew
import com.aicontent.model.comic.domain.MangaModel

class GetAllManga(private val mangaRepositoryNew: MangaRepositoryNew): UseCase<List<MangaModel>>(){
    override suspend fun run(params: Map<String, Any?>): List<MangaModel> {
        val forceReload = params["forceReload"] as Boolean

        return mangaRepositoryNew.getAllManga(forceReload)
    }
}
//class GetAllManga(private val mangaRepositoryNew: MangaRepositoryNew) : UseCase<List<MangaModel>>() {
//    override suspend fun run(params: Map<String, Any?>): List<MangaModel> {
//        val forceReload = params["forceReload"] as? Boolean ?: false
//
//        return try {
//            val mangaList = mangaRepositoryNew.getAllManga(forceReload)
//            Result.Success(mangaList)
//        } catch (e: Exception) {
//            Result.Failure(e)
//        }
//    }
//}

class InsertManga(private val mangaRepositoryNew: MangaRepositoryNew): UseCase<MangaModel>() {
    override suspend fun run(params: Map<String, Any?>): MangaModel {
        val forceReload = params["forceReload"] as Boolean
        val manga = params["comicId"] as MangaModel

        return mangaRepositoryNew.insertManga(comic = manga)
    }

}