package com.aicontent.comicbook.android

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.aicontent.comicbook.MainScreen
import com.aicontent.comicbook.android.loginApp.ChangePinScreen
import com.aicontent.comicbook.android.loginApp.LoginScreen
import com.aicontent.comicbook.android.loginApp.UserManager
import com.aicontent.comicbook.viewmodel.ApplicationViewModel
import org.koin.android.ext.android.inject
import org.koin.core.component.KoinComponent

class MainActivity() : ComponentActivity(), KoinComponent {
    private val applicationViewModel: ApplicationViewModel by inject()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val preferences = getSharedPreferences("app_preferences", Context.MODE_PRIVATE)
        val userManager = UserManager(preferences)

        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box {
                        val navController = rememberNavController()

                        NavHost(navController, startDestination = "login") {
                            composable("login") {
                                LoginScreen(
                                    userManager,navController)
                            }
                            composable("changePin") {
                                ChangePinScreen(
                                    userManager, navController
                                )
                            }
                            composable("main") {
                                MainScreen(viewModel = applicationViewModel)
                            }
                        }
                    }
                }
            }
        }
    }
}
