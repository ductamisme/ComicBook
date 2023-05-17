package com.aicontent.comic.ui.homePage.homePage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aicontent.local.time.DateTimeUtil
import com.aicontent.model.comic.local.ComicsEntity

@Composable
fun ItemComics(
    comicsEntity: ComicsEntity,
    onComicClick: () -> Unit,
    onComicDelete: () -> Unit
) {
    val formattedDate = remember(comicsEntity.created) {
        DateTimeUtil.formatNoteDate(comicsEntity.created)
    }
    Card(
        elevation = 4.dp,
        backgroundColor = Color.White,
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier
            .clip(RoundedCornerShape(5.dp))
            .clickable(onClick = { onComicClick() })
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = comicsEntity.title,
                    fontSize = 20.sp,
                    fontStyle = FontStyle.Italic
                )
                IconButton(
                    onClick = onComicDelete,
                    content = {
                        Icon(Icons.Filled.Close, null)
                    }
                )
            }
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = comicsEntity.category,
                fontSize = 10.sp,
                fontStyle = FontStyle.Normal
            )
            Spacer(modifier = Modifier.padding(8.dp))
            Text(
                text = comicsEntity.description,
                fontSize = 15.sp,
                fontStyle = FontStyle.Normal
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
//                IconWithText(
//                    icon = Icons.Filled.Person,
//                    text = comicsEntity.author,
//                    isFilled = false
//                )
//                IconWithText(
//                    icon = Icons.Filled.List,
//                    text = comicsEntity.pageCount.toString(),
//                    isFilled = false
//                )
//                IconWithText(
//                    icon = Icons.Filled.Check,
//                    text = comicsEntity.created.toString(),
//                    isFilled = false
//                )
//                IconWithText(
//                    icon = Icons.Filled.Favorite,
//                    text = comicsEntity.favorites.toString(),
//                    isFilled = false
//                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = formattedDate,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.End)
            )
        }
    }
}

@Composable
fun IconWithText(
    icon: ImageVector,
    text: String,
    isFilled: Boolean
) {
    val color = if (isFilled) MaterialTheme.colors.primary else Color.Gray
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = color,
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.padding(4.dp))
        Text(
            text = text,
            fontSize = 14.sp,
            color = color,
            fontStyle = FontStyle.Normal
        )
    }
}