package com.aicontent.comicbook

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aicontent.comicbook.ui.MainComposeScreen
import com.aicontent.comicbook.viewmodel.ApplicationViewModel
import com.aicontent.local.comic.ComicsDataSource

@Composable
fun MainScreen(
    viewModel: ApplicationViewModel,
//    dataSource: ComicsDataSource
) {
    MainComposeScreen(viewModel = viewModel,modifier = Modifier.systemBarsPadding())

}

//class SampleApp : Application() {
//
//    override fun onCreate() {
//        super.onCreate()
//
//        ScreenRegistry {
//            featurePostsScreenModule()
//        }
//    }
//}