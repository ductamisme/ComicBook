package com.aicontent.comic.di

import com.aicontent.comic.viewModel.settings.SettingsViewModel
import org.koin.dsl.module

val featureComicModule = module{
    single { SettingsViewModel.Factory(get())}

}