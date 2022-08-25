package com.example.technicaltest.presentation.character_list

import com.example.technicaltest.domain.model.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String = ""
)
