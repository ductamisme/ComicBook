package com.aicontent.comicbook.android

import android.app.Application
import com.aicontent.comicbook.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.KoinApplication
import org.koin.core.logger.Level

class ComicBookApplication:Application() {
    lateinit var koin : KoinApplication

    override fun onCreate() {
        super.onCreate()

        koin = initKoin{
            androidLogger(level = if (BuildConfig.DEBUG) Level.ERROR else Level.NONE)
            androidContext(androidContext = this@ComicBookApplication)
        }
    }
}