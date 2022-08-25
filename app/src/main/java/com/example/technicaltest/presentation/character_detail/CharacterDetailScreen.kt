package com.example.technicaltest.presentation.character_list

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.technicaltest.presentation.character_detail.CharacterDetailViewModel
import com.example.technicaltest.presentation.character_detail.components.CharacterPicture
import com.example.technicaltest.presentation.character_detail.components.InformationItem

@Composable
fun CharacterDetailScreen(
    viewModel: CharacterDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.character?.let { character ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(150.dp),
                    ) {
                        CharacterPicture(url = character.image)
                        Text(
                            text = "${character.id}. ${character.name}",
                            color = MaterialTheme.colors.primary,
                            style = MaterialTheme.typography.h1,
                            modifier = Modifier
                                .weight(8f)
                                .align(Alignment.CenterVertically),
                            textAlign = TextAlign.Center
                        )
                        //Text to write if character is dead/alive/unknown
                    }
                    Spacer(modifier = Modifier.height(25.dp))

                    //General informations
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "General informations",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(5f)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    InformationItem(name = "Gender", data = character.gender)
                    InformationItem(name = "Species", data = character.species)
                    if (character.type != "") {
                        InformationItem(name = "Type", data = character.type!!)
                    }
                    InformationItem(name = "Status", data = character.status)
                    InformationItem(name = "Location", data = character.location.name)
                    InformationItem(name = "Origin", data = character.origin.name)

                    Spacer(modifier = Modifier.height(25.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Episodes",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(5f)
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                }
                items(character.episode) { episode ->
                    InformationItem(name = episode.episode, data = episode.name)
                }
            }
        }
        if (state.error.isNotBlank()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}