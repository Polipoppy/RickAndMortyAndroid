package com.example.technicaltest.data.remote.dto

import com.example.technicaltest.domain.model.Character

data class CharacterDto(
    val id: Int,
    val image: String,
    val name: String
)

fun CharacterDto.toCharacter(): Character {
    return Character(
        id = id,
        name = name,
        image = image
    )
}