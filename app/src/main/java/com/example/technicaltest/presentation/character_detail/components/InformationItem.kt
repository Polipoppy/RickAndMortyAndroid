package com.example.technicaltest.presentation.character_detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InformationItem(
    name: String,
    data: String,
/*    modifier: Modifier = Modifier*/
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
    ) {
        Text(
            text = "${name}: ",
            style = MaterialTheme.typography.body1,
        )
        Text(
            text = data,
            style = MaterialTheme.typography.body1,
            color = MaterialTheme.colors.primary
        )
    }
}