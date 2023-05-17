package com.aicontent.comic.viewModel.settings

import com.aicontent.domain.comic.usecases.GetAllManga
import com.aicontent.domain.comic.usecases.GetComicByIdUseCase
import com.aicontent.domain.comic.usecases.InsertManga
import com.aicontent.model.comic.domain.ComicModel
import com.aicontent.model.comic.domain.MangaModel
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.brightify.hyperdrive.multiplatformx.BaseViewModel
import org.koin.core.component.KoinComponent

class HomePageViewModel(
    private val getAllManga: GetAllManga,
    private val insertManga: InsertManga
) : BaseViewModel(), KoinComponent {

    private val _getMangaList = MutableStateFlow<List<MangaModel>>(emptyList())
    val getMangaList = _getMangaList.asStateFlow()

    private val _insertManga = MutableStateFlow<MangaModel?>(null)
    val insertMangaNew = _insertManga.asStateFlow()

    @OptIn(DelicateCoroutinesApi::class)
    fun getAllManga(forceReload: Boolean) {
        kotlinx.coroutines.GlobalScope.launch {
            val map = mutableMapOf<String, Any>()

            map["forceReload"] = forceReload

            val result = getAllManga(map)
            _getMangaList.value = result
            println("result $result")
        }
    }

    @OptIn(DelicateCoroutinesApi::class)
    fun insertManga(forceReload: Boolean) {
        kotlinx.coroutines.GlobalScope.launch {
            val map = mutableMapOf<String, Any>()

            map["forceReload"] = forceReload

            val result = insertManga(map)
            _insertManga.value = result
            println("result $result")
        }
    }


    class Factory(
        private val getAllManga: GetAllManga,
        private val insertManga: InsertManga
    ) {
        fun create() = HomePageViewModel(getAllManga, insertManga)
    }
}