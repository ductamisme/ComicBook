package com.aicontent.comic.ui.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import com.aicontent.model.comic.local.ComicsEntity

sealed class SharedScreen : ScreenProvider {
    object HomePageScreen : SharedScreen(){
    }
    object AddScreen : SharedScreen(){}
    data class EditScreen(val comicEntity: ComicsEntity) : SharedScreen()
    object TopicScreen: SharedScreen()
    object SearchScreen: SharedScreen()
    object AvatarScreen: SharedScreen()
}

