package com.aicontent.comic.ui.Notification

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier

@Composable
fun NotificationScreen(){
    Text(text = "notification")
}

//@Composable
//fun DropDownMenu(
//    options: List<String>,
//    selectedOption: String,
//    onOptionSelected: (String) -> Unit
//) {
//    var expanded by remember { mutableStateOf(false) }
//
//    Box {
//        Text(
//            text = selectedOption,
//            modifier = Modifier.clickable { expanded = true }
//        )
//        DropdownMenu(
//            expanded = expanded,
//            onDismissRequest = { expanded = false }
//        ) {
//            options.forEach { option ->
//                DropdownMenuItem(
//                    onClick = {
//                        onOptionSelected(option)
//                        expanded = false
//                    }
//                ) {
//                    Text(text = option)
//                }
//            }
//        }
//    }
//}
