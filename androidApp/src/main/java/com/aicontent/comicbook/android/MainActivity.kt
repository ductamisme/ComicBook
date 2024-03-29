package com.aicontent.comicbook.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.aicontent.comicbook.Greeting
import androidx.compose.runtime.*
import com.aicontent.comicbook.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
//                    var text by remember { mutableStateOf("Loading") }
//                    LaunchedEffect(true) {
//                        text = try {
//                            Greeting().greet()
//                        } catch (e: Exception) {
//                            e.localizedMessage ?: "error"
//                        }
//                    }
//                    GreetingView(text)
                    App()
                }
            }
        }
    }
}


@Composable
fun GreetingView(text: String) {
    Text(text = text)
}

@Preview
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        GreetingView("Hello, Android!")
    }
}
