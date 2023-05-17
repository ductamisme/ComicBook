package com.aicontent.comicbook.android.authentication.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.aicontent.comicbook.MainScreen
import com.aicontent.comicbook.android.authentication.presentation.login_screen.SignInScreen
import com.aicontent.comicbook.android.authentication.presentation.signup_screen.RegisterScreen
import com.aicontent.comicbook.viewmodel.ApplicationViewModel


@Composable
fun NavigationGraph(
    navController: NavHostController,
    applicationViewModel: ApplicationViewModel,
//    comicsViewModel : ComicsViewModel
) {
    NavHost(
        navController = navController,
        startDestination = Screens.SignInScreen.route
    ) {
        composable(route = Screens.SignInScreen.route) {
            SignInScreen(navController)
        }
        composable(route = Screens.RegisterScreen.route) {
            RegisterScreen(navController)
        }
        composable(route = Screens.MainScreen.route){
            MainScreen(applicationViewModel)
        }
    }

}
