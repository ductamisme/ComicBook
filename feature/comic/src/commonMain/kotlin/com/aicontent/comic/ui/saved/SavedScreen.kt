package com.aicontent.comic.ui.saved

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.rememberScreenModel
import cafe.adriel.voyager.core.screen.Screen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.datetime.Clock

//import com.aicontent.comic.ui.homePage.SearchScreen.SearchScreen


class SavedScreens() : Screen {
    @Composable
    override fun Content() {
        val viewModel = rememberScreenModel { RandomViewModel() }
        val randomNumber by viewModel.randomNumber.collectAsState()
        val newSampleNumber by viewModel.newSampleNumber.collectAsState()

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Random Number: $randomNumber", fontSize = 24.sp)
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = { viewModel.generateRandomNumber() },
                modifier = Modifier.padding(16.dp)
            ) {
                Text(text = "Generate Random")
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "New Sample Number: $newSampleNumber", fontSize = 24.sp)
        }
    }
}

class RandomViewModel : ScreenModel {
    private val _randomNumber = MutableStateFlow("")
    val randomNumber: StateFlow<String> = _randomNumber

    private val _newSampleNumber = MutableStateFlow("")
    val newSampleNumber: StateFlow<String> = _newSampleNumber

    fun generateRandomNumber() {
        // this case any time i click the button it will create a new number "ramdom"
        // True Random Algorithm
        val randomNumber = (Clock.System.now().nanosecondsOfSecond)

        // Fake Random Algorithm
        var sampleNumber = randomNumber.toString().substring(1, 5).toInt()
//        sampleNumber = sampleNumber * sampleNumber
        sampleNumber *= sampleNumber
        val newSample = sampleNumber.toString().substring(3, 5)

        _randomNumber.value = randomNumber.toString().substring(1, 3)
        _newSampleNumber.value = newSample
    }
}