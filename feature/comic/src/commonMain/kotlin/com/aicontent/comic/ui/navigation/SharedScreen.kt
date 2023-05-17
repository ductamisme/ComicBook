package com.aicontent.comic.ui.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {

    object HomePageScreen : SharedScreen(){
    }

    object AddScreen : SharedScreen() {
    }
    object TopicScreen: SharedScreen()
    object SearchScreen: SharedScreen()

    object EditScreen: SharedScreen()

}

