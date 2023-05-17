package com.aicontent.comicbook.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.aicontent.comicbook.viewmodel.ApplicationViewModel
import com.aicontent.local.comic.ComicsDataSource
import org.jetbrains.codeviewer.ui.theme.DroidconTheme

@Composable
internal fun MainComposeScreen(
    viewModel: ApplicationViewModel,
//    comicsViewModel: ComicsViewModel,
//    dataSource : ComicsDataSource,
    modifier: Modifier = Modifier
) {
    DroidconTheme {
        BottomNavigationScreen(viewModel = viewModel, modifier = modifier)
    }
}