package com.aicontent.comicbook

import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aicontent.comicbook.ui.MainComposeScreen
import com.aicontent.comicbook.viewmodel.ApplicationViewModel

@Composable
fun MainScreen(viewModel: ApplicationViewModel){
    MainComposeScreen(viewModel = viewModel, modifier = Modifier.systemBarsPadding())
}