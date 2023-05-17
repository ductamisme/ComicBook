package com.aicontent.comic.ui.topics

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aicontent.comic.ui.ImageItem

@Composable
fun HotItems(
    modifier: Modifier,
//    id: String,
    title: String,
//    description: String,
    category: String,
//    author: String,
//    pageCount: String,
//    isFavorite: String,
//    isComplete: String,
    url: String,
//    viewModel: ComicsViewModel,
//    onComicClick: () -> Unit,
//    onComicDelete: () -> Unit
) {
    Card(
        elevation = 4.dp,
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, Color.LightGray),
    ) {
        Column(modifier = Modifier
            .clip(RoundedCornerShape(5.dp)).clickable {
//                onComicClick()
            }
            .padding(16.dp)) {
            Column(modifier = Modifier.padding(8.dp)) {
                ImageItem(url, modifier = modifier)

                Text(
                    text = title,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = category,
                    fontSize = 10.sp,
                    fontStyle = FontStyle.Italic
                )

            }
        }
    }
    Spacer(modifier = Modifier.padding(end = 24.dp))
}