package com.aicontent.comicbook.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Save
import androidx.compose.material.icons.filled.Token
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.Navigator
import com.aicontent.comic.ui.Notification.NotificationScreen
//import com.aicontent.comic.ui.Notification.AddScreen
//import com.aicontent.comic.ui.Notification.NotificationScreen
//import com.aicontent.comic.ui.saved.ComicsScreen
import com.aicontent.comic.ui.homePage.homePage.HomePageScreen
import com.aicontent.comic.ui.saved.SavedScreens
import com.aicontent.comic.ui.topics.TopicsScreen
import com.aicontent.comicbook.viewmodel.ApplicationViewModel
import org.jetbrains.codeviewer.ui.util.observeAsState

@Composable
internal fun BottomNavigationScreen(
    viewModel: ApplicationViewModel,
    modifier: Modifier = Modifier
) {
    val selectedTabs by viewModel.observeSelectedTab.observeAsState()

    Scaffold(
        modifier = modifier,
        bottomBar = {
            BottomNavigation(elevation = 0.dp, backgroundColor = MaterialTheme.colors.primary) {
                viewModel.tabs.forEach { tab ->
                    val (title, icon) = when (tab) {
                        ApplicationViewModel.Tab.HomePage -> "HomePage" to Icons.Filled.Home
                        ApplicationViewModel.Tab.Topics -> "Topics" to Icons.Filled.Token
                        ApplicationViewModel.Tab.Saved -> "Saved" to Icons.Filled.Save
                        ApplicationViewModel.Tab.Notification -> "Notification" to Icons.Filled.Notifications
                    }
                    BottomNavigationItem(
                        icon = { Icon(imageVector = icon, contentDescription = null) },
                        label = { Text(text = title) },
                        selected = selectedTabs == tab,
                        onClick = {
                            viewModel.selectedTab = tab
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (selectedTabs) {
                ApplicationViewModel.Tab.HomePage -> Navigator(HomePageScreen())
                ApplicationViewModel.Tab.Topics -> Navigator(TopicsScreen())
                ApplicationViewModel.Tab.Saved -> SavedScreens()
                ApplicationViewModel.Tab.Notification -> NotificationScreen()
            }
        }
    }
}
