package com.aicontent.comicbook.android.loginApp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun ChangePinScreen(userManager: UserManager, navController: NavController) {
    val context = LocalContext.current
    var oldPin by remember { mutableStateOf("") }
    var newPin by remember { mutableStateOf("") }
    var confirmPin by remember { mutableStateOf("") }
    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Change PIN",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = oldPin,
            onValueChange = { oldPin = it },
            label = { Text("Current PIN") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            isError = showError,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp).padding(horizontal = 32.dp)

        )

        OutlinedTextField(
            value = newPin,
            onValueChange = { newPin = it },
            label = { Text("New PIN") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            isError = showError,
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp).padding(horizontal = 32.dp)

        )

        OutlinedTextField(
            value = confirmPin,
            onValueChange = { confirmPin = it },
            label = { Text("Confirm PIN") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            isError = showError,
            modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp).padding(horizontal = 32.dp)

        )

        Button(
            onClick = {
                if (userManager.verifyPin(oldPin) && newPin == confirmPin) {
                    userManager.changePin(oldPin, newPin)
                    navController.navigate("login")
                    showToast(context, "Navigated to Login")

                } else {
                    showError = true
                }
            },
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text("Change PIN")
        }

        if (showError) {
            showToast(context, "Invalid PIN")
        }

        CustomButton(
            onClick = {
                navController.navigate("login")
                showToast (context, "Navigated to Login")
            },
            text = "Return to Login",
            modifier = Modifier.padding(top = 16.dp).padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.padding(100.dp))

    }
}

@Composable
fun CustomButton(onClick: () -> Unit, text: String, modifier: Modifier = Modifier) {
    Button(
        onClick = onClick,
        modifier = modifier
    ) {
        Text(text)
    }
}
