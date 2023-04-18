package com.aicontent.comic.ui.homePage

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun HomePageScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("News") },
                elevation = 0.dp,
                modifier = Modifier.shadow(AppBarDefaults.TopAppBarElevation),
                backgroundColor = MaterialTheme.colors.primary,
            )
        },
    ) {
        val scrollState = rememberScrollState()
        Column(modifier = Modifier.fillMaxHeight().verticalScroll(scrollState)) {
            CompWalletCreateWallet()
        }
    }
}

@Composable
fun CompWalletCreateWallet(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color(0.98f, 0.98f, 0.98f, 1.0f))
    ) {
        Column(
            modifier = Modifier
                .padding(start = 16.dp, top = 16.dp)
        ) {
            Text(
                "Start your crypto wallet journey",
                style = LocalTextStyle.current.copy(
                    color = Color(0.28f, 0.28f, 0.28f, 1.0f),
                    textAlign = TextAlign.Left,
                    fontSize = 28.sp
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { /* Handle create wallet click */ },
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .fillMaxWidth(0.9f),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(1.0f, 0.35f, 0.37f, 1.0f),
                    contentColor = Color.White
                )
            ) {
                Text("Create a wallet", fontSize = 17.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    "Import existing wallet",
                    style = LocalTextStyle.current.copy(
                        color = Color(1.0f, 0.35f, 0.37f, 1.0f),
                        textAlign = TextAlign.Left,
                        fontSize = 17.sp
                    )
                )
            }
        }
    }
}

@Composable
fun CompWalletCreateWallet() {
    CompWalletCreateWallet(Modifier.fillMaxSize())
}




