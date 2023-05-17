package com.aicontent.comicbook.android.authentication.di

import com.aicontent.comicbook.android.authentication.data.AuthRepository
import com.aicontent.comicbook.android.authentication.data.AuthRepositoryImpl
import com.google.firebase.auth.FirebaseAuth
import org.koin.dsl.module

fun appModule() = module {

    single { FirebaseAuth.getInstance() }

    single<AuthRepository> { AuthRepositoryImpl(get()) }
}
