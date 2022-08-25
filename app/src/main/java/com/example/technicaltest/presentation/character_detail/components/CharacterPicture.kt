package com.example.technicaltest.presentation.character_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter

@Composable
fun CharacterPicture(
    url: String,
) {
    Image(
        painter = rememberAsyncImagePainter(url),
        contentDescription = null,
        modifier = Modifier.size(150.dp)
            .border(width = 1.8.dp, color = Color.White, shape = RoundedCornerShape(32.dp))
            .clip(RoundedCornerShape(32.dp))
    )
}
