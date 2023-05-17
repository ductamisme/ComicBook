package com.aicontent.local.di

import com.aicontent.local.comic.ComicLocalDataSource
import com.aicontent.local.comic.ComicsDataSource
import com.aicontent.local.comicImpl.ComicLocalDataSourceImpl
import com.aicontent.local.comicImpl.ComicsDataSourceImpl
import com.aicontent.local.useCase.UseCaseDeleteAllNote
import com.aicontent.local.useCase.UseCaseDeleteById
import com.aicontent.local.useCase.UseCaseInsertComics
import com.aicontent.local.useCase.UseCaseGetAllComics
import org.koin.dsl.module

fun localModule() = module {
    single<ComicLocalDataSource> { ComicLocalDataSourceImpl(get()) }
    single<ComicsDataSource> { ComicsDataSourceImpl(get()) }
    single { UseCaseInsertComics(get()) }
    single { UseCaseGetAllComics(get()) }
    single { UseCaseDeleteById(get()) }
    single { UseCaseDeleteAllNote(get()) }

}
