package com.aicontent.remote.di

import com.aicontent.remote.comic.ComicApi
import com.aicontent.remote.comic.ComicRemoteDataSource
import de.jensklingenberg.ktorfit.Ktorfit
import de.jensklingenberg.ktorfit.converter.builtin.CallResponseConverter
import de.jensklingenberg.ktorfit.converter.builtin.FlowResponseConverter
import de.jensklingenberg.ktorfit.ktorfit
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.dsl.module

fun remoteModule(baseUrl: String, enableNetworkLogs: Boolean) = module {
    single {
        Ktorfit.Builder()
            .baseUrl(baseUrl)
            .httpClient(HttpClient {
                install(ContentNegotiation) {
                    json(Json { isLenient = true; ignoreUnknownKeys = true; prettyPrint = true })
                }
                if (enableNetworkLogs) {
                    install(Logging) {
                        level = LogLevel.BODY
                        logger = object : Logger {
                            override fun log(message: String) {
                                Napier.i(tag = "Http Client", message = message)
                            }
                        }
                    }.also {
                        Napier.base(DebugAntilog())
                    }
                }
            })
            .responseConverter(FlowResponseConverter(), CallResponseConverter())
            .build()
    }
    single<ComicApi> { get<Ktorfit>().create() }
    single { ComicRemoteDataSource(get()) }
}