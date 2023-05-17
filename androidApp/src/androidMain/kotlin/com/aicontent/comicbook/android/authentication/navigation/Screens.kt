package com.aicontent.comicbook.android.authentication.navigation

sealed class Screens(val route: String) {
    object SignInScreen : Screens(route = "SignIn_Screen")
    object RegisterScreen : Screens(route = "SignUp_Screen")
    object MainScreen : Screens(route = "MainScreen_Screen")
}