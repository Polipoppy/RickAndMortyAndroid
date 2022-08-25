package com.example.technicaltest.domain.model

data class CharacterDetail(
    val created: String,
    val episode: MutableList<Episode>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: Location,
    val name: String,
    val origin: Location,
    val species: String,
    val status: String,
    val type: String?,
)