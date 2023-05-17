package com.aicontent.domain.di

import com.aicontent.domain.comic.repository.ComicRepository
import com.aicontent.domain.comic.repository.ComicRepositoryImpl
import com.aicontent.domain.comic.usecases.GetComicByIdUseCase
import org.koin.dsl.module

fun domainModule() = module {
    single<ComicRepository> { ComicRepositoryImpl(get(), get()) }
    single { GetComicByIdUseCase(get()) }
}