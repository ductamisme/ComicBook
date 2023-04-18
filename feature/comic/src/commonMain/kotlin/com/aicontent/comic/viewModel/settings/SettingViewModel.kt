package com.aicontent.comic.viewModel.settings

import com.aicontent.domain.comic.usecases.GetComicByIdUseCase
import com.aicontent.model.comic.domain.ComicModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.brightify.hyperdrive.multiplatformx.BaseViewModel
import org.koin.core.component.KoinComponent

class SettingsViewModel(
    private val getComicByIdUseCase: GetComicByIdUseCase
) : BaseViewModel(), KoinComponent {

    private val _getComic = MutableStateFlow<ComicModel?>(null)
    val getComic = _getComic.asStateFlow()

    fun loadComic(forceReload :Boolean, comicId: Int){
        kotlinx.coroutines.GlobalScope.launch {
            val map = mutableMapOf<String, Any>()
            map["forceReload"] = forceReload
            map["comicId"] = comicId
            val result = getComicByIdUseCase(map)
            _getComic.value = result
            println("result $result")
        }
    }

    class Factory(
        private val getComicByIdUseCase: GetComicByIdUseCase
    ){
        fun create() = SettingsViewModel(getComicByIdUseCase)
    }
}