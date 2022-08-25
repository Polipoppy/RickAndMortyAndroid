package com.example.technicaltest.presentation.character_detail

import com.example.technicaltest.domain.model.CharacterDetail

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: CharacterDetail? = null,
    val error: String = ""
)
