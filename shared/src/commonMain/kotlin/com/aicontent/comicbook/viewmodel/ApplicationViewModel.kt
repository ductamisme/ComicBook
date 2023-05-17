package com.aicontent.comicbook.viewmodel

import com.aicontent.comic.ui.homePage.homePage.HomePageViewModel
import com.aicontent.comic.viewModel.settings.SettingsViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import org.brightify.hyperdrive.multiplatformx.BaseViewModel

class ApplicationViewModel(settingsFactory: SettingsViewModel.Factory, comicsViewModel: HomePageViewModel.Factory):BaseViewModel() {
    val settings by managed(settingsFactory.create())

    val comicViewModel by managed(comicsViewModel.create())

    val tabs = listOf(Tab.HomePage, Tab.Topics, Tab.Saved, Tab.Notification)

    var selectedTab: Tab by published(Tab.HomePage)
    // use for onclick

    val observeSelectedTab by observe(::selectedTab)
    // use for selected = selectedTabs == tab,
//
//    val adds = listOf(Add.Add, Add.Create)
//
//    var selectedAdd: Add by published(Add.Create)
//
//    val observeSelectedAdd by observe(::selectedAdd)

    var showSplashScreen = MutableStateFlow(true)

    val useCompose : Boolean = true

    init {
        lifecycle.whileAttached {
           // i will do something here
        }
        lifecycle.whileAttached {
            // as above
        }
    }

    fun onAppear(){
        lifecycle.whileAttached {
            // as above too
        }
    }
    enum class Tab{
        HomePage, Topics, Saved, Notification
    }
    enum class Add{
        Create, Add
    }
}