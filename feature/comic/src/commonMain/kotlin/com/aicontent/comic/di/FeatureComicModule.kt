package com.aicontent.comic.di

import cafe.adriel.voyager.core.registry.screenModule
import com.aicontent.comic.ui.homePage.add.AddScreen
import com.aicontent.comic.ui.homePage.add.EditScreen
import com.aicontent.comic.ui.homePage.homePage.HomePageViewModel
import com.aicontent.comic.ui.homePage.homePage.HomePageScreen
import com.aicontent.comic.ui.homePage.SearchScreen.SearchScreen
import com.aicontent.comic.ui.homePage.information.AvatarScreen
import com.aicontent.comic.ui.navigation.SharedScreen
import com.aicontent.comic.ui.topics.TopicsScreen
import com.aicontent.comic.viewModel.settings.SettingsViewModel
import org.koin.dsl.module

val featureComicModule = module {
    single { SettingsViewModel.Factory(get()) }
    single { HomePageViewModel.Factory(get()) }
    factory { HomePageViewModel() }
}

val ComicModule = screenModule {
    register<SharedScreen.AddScreen> {
        AddScreen()
    }
    register<SharedScreen.TopicScreen> {
        TopicsScreen()
    }
    register<SharedScreen.HomePageScreen> {
        HomePageScreen()
    }
    register<SharedScreen.SearchScreen> {
        SearchScreen()
    }
    register<SharedScreen.EditScreen> {provider ->
        EditScreen(comic = provider.comicEntity)
    }
    register<SharedScreen.AvatarScreen> {
        AvatarScreen()
    }
}

