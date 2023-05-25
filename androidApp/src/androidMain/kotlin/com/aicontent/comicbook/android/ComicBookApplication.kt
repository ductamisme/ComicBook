package com.aicontent.comicbook.android

import android.app.Application
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.aicontent.comicbook.MainScreen
import com.aicontent.comicbook.android.authentication.di.appModule
import com.aicontent.comicbook.di.initKoin
import com.aicontent.comicbook.viewmodel.ApplicationViewModel
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class ComicBookApplication : Application() {
    lateinit var koin: KoinApplication
    private val applicationViewModel: ApplicationViewModel by inject()
    override fun onCreate() {
        super.onCreate()
        koin = initKoin {
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@ComicBookApplication)
        }
    }
}