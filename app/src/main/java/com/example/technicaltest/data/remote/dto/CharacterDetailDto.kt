package com.example.technicaltest.data.remote.dto

import com.example.technicaltest.domain.model.CharacterDetail
import com.example.technicaltest.domain.model.Episode

data class CharacterDetailDto(
    val created: String,
    val episode: MutableList<EpisodeDto>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: LocationDto,
    val name: String,
    val origin: LocationDto,
    val species: String,
    val status: String,
    val type: String?,
)

fun CharacterDetailDto.toCharacterDetail(): CharacterDetail {
    return CharacterDetail(
        created = created,
        episode = episode.map { it.toEpisode() } as MutableList<Episode>,
        gender = gender,
        id = id,
        image = image,
        location = location.toLocation(),
        name = name,
        origin = origin.toLocation(),
        species = species,
        status = status,
        type = type,
    )
}