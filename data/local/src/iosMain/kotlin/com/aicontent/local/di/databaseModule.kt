package com.aicontent.local.di

import com.aicontent.database.ComicBookDatabase
import com.aicontent.local.ComicBookDatabaseWrapper
//import com.mangala.wallet.database.MangalaWalletDatabase
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver
import org.koin.dsl.module

actual fun databaseModule() = module {
    single {
        var driver = NativeSqliteDriver(ComicBookDatabase.Schema,"comic.db")
        ComicBookDatabaseWrapper(ComicBookDatabase(driver))
    }
}