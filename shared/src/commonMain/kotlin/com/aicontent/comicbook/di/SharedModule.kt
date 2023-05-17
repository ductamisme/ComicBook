package com.aicontent.comicbook.di

//import com.aicontent.comic.di.appModule
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.aicontent.comic.di.ComicModule
import com.aicontent.comic.di.featureComicModule
import com.aicontent.comicbook.viewmodel.ApplicationViewModel
import com.aicontent.domain.di.domainModule
import com.aicontent.local.di.databaseModule
import com.aicontent.local.di.localModule
import com.aicontent.local.useCase.UseCaseInsertComics
import com.aicontent.remote.di.remoteModule
//import com.mangala.wallet.ui.SharedScreen
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(enableNetworkLogs: Boolean = true, appDeclaration: KoinAppDeclaration = {}) =
    startKoin {
        appDeclaration()
        modules(
            databaseModule(),
            localModule(),
            remoteModule("https://swapi.dev/api/", enableNetworkLogs),
            domainModule(),
            shareModule,
            featureComicModule
//            appModule
        )
    }

val shareModule = module {
    single {
        ApplicationViewModel(
            settingsFactory = get(),
            comicsViewModel = get()
        )
    }
    ScreenRegistry {
        ComicModule()
//        register<SharedScreen.HomeScreen> {
//            HomeScreen()
//        }
    }
}

fun KoinApplication.Companion.start(): KoinApplication = initKoin { }