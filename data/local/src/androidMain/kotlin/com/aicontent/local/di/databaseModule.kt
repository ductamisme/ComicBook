package com.aicontent.local.di

import com.aicontent.database.ComicBookDatabase
import com.aicontent.local.ComicBookDatabaseWrapper
//import com.mangala.wallet.database.MangalaWalletDatabase
import com.squareup.sqldelight.android.AndroidSqliteDriver
import org.koin.dsl.module

actual fun databaseModule() = module {
    single {
        val driver = AndroidSqliteDriver(ComicBookDatabase.Schema, get(), "comic.db")
        ComicBookDatabaseWrapper(ComicBookDatabase(driver))
    }
}