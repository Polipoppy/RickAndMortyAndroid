package com.example.technicaltest.data.remote.dto

import com.example.technicaltest.domain.model.Episode
import com.example.technicaltest.domain.model.EpisodeDetail

data class EpisodeDetailDto(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
)

fun EpisodeDetailDto.toEpisodeDetail(): EpisodeDetail {
    return EpisodeDetail(
        air_date = air_date,
        characters = characters,
        created = created,
        episode = episode,
        id = id,
        name = name,
    )
}