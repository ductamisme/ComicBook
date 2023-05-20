package com.aicontent.comicbook

import androidx.compose.ui.window.Application
import com.aicontent.comicbook.ui.MainComposeScreen
import com.aicontent.comicbook.viewmodel.ApplicationViewModel
import io.ktor.http.ContentType

fun getRootController(viewModel: ApplicationViewModel) = Application("MainComposeScreen") {
    MainComposeScreen(viewModel)
}
//fun getRootController(viewModel: ApplicationViewModel) = Application("MainComposeView") {
//    MainComposeView(viewModel)
//}
