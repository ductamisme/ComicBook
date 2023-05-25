package com.aicontent.comicbook.android.loginApp

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aicontent.comicbook.android.R

@Composable
fun LoginScreen(
    userManager: UserManager,
    navController: NavController
) {
    var pin by remember { mutableStateOf("") }
    val context = LocalContext.current
    val interactionSource = remember { MutableInteractionSource() }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Login",
            style = MaterialTheme.typography.h4,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = "The first time password is null",
            style = MaterialTheme.typography.caption,
            fontWeight = FontWeight.Thin,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        OutlinedTextField(
            value = pin,
            onValueChange = { pin = it },
            label = { Text("Enter PIN") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (userManager.verifyPin(pin)) {
                    userManager.setLoggedIn()
                    navController.navigate("main")
                } else {
                    showToast(context, "Wrong pin code")
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Login")
        }
        Text(
            text = buildAnnotatedString {
                append(stringResource(id = R.string.Forgot_password))
                withStyle(SpanStyle(color = Color.Blue)) {
                    append(stringResource(id = R.string.change))
                }
            },
            fontSize = fontSizeDimensionResource(id = R.dimen.textSize_login_registerTextButton),
            modifier = Modifier.clickable(
                interactionSource = interactionSource,
                indication = null,
            ) {
                Toast.makeText(
                    context,
                    "Navigated to login",
                    Toast.LENGTH_SHORT,
                ).show()
                showToast(context, "Navigated to Change Pin")
                navController.navigate("changePin")
            },
        )

//        val underlineClickableStyle = SpanStyle(
//            textDecoration = TextDecoration.Underline,
//            color = MaterialTheme.colors.secondary
//        )
//
//        val annotatedText = buildAnnotatedString {
//            append(stringResource(id = R.string.Forgot_password))
//            withStyle(style = underlineClickableStyle) {
//                append(" ")
//                append(stringResource(id = R.string.change))
//            }
//        }
//
//        Text(
//            text = annotatedText,
//            fontSize = fontSizeDimensionResource(id = R.dimen.textSize_login_registerTextButton),
//            modifier = Modifier
//                .padding(top = 8.dp)
//                .clickable(
//                    interactionSource = interactionSource,
//                    indication = null
//                ) {
//                    showToast(context, "Navigated to Change Pin")
//                    navController.navigate("changePin")
//                }
//        )

        Spacer(modifier = Modifier.padding(150.dp))
    }
}

fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}


