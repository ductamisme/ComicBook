package com.aicontent.comicbook.di

import com.aicontent.comic.di.featureComicModule
import com.aicontent.comicbook.viewmodel.ApplicationViewModel
import com.aicontent.remote.di.remoteModule
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(enableNetworkLogs: Boolean = true, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
//            databaseModule(),
//            localModule(),
            remoteModule("https://swapi.dev/api/", enableNetworkLogs),
//            domainModule(),
            shareModule,
            featureComicModule
        )
    }

val shareModule = module {
    single {
        ApplicationViewModel(settingsFactory = get())
    }
}

fun KoinApplication.Companion.start(): KoinApplication = initKoin { }