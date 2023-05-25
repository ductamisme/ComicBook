//package com.aicontent.comic.ui.saved
//
//import androidx.compose.runtime.Composable
//import cafe.adriel.voyager.core.annotation.InternalVoyagerApi
//import cafe.adriel.voyager.navigator.Navigator
//
//@OptIn(InternalVoyagerApi::class)
//val navigator = Navigator<Screen>()
//
//sealed class Screen : Voyager {
//    object ItemList : Screen()
//    data class ItemDetails(val item: Item) : Screen()
//}
//
//// Define the screens and their respective composables
//val screens: Map<Screen, @Composable (Voyager) -> Unit> = mapOf(
//    Screen.ItemList to { voyager -> ItemListScreen(voyager.pass("items"), voyager.actions.toItemDetails()) },
//    isInstance(Screen.ItemDetails::class) to { voyager -> ItemDetailsScreen(voyager.pass<Screen.ItemDetails>().item) }
//)
//
//// Define the actions to navigate between screens
//fun Navigator<Screen>.toItemDetails(): (Item) -> Unit = { item ->
//    publish(Screen.ItemDetails(item))
//}
