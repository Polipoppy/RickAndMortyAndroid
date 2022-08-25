package com.example.technicaltest.data.remote.dto

import com.example.technicaltest.domain.model.Episode
import com.example.technicaltest.domain.model.EpisodeDetail

data class EpisodeDto(
    val air_date: String,
    val episode: String,
    val id: Int,
    val name: String,
)

fun EpisodeDto.toEpisode(): Episode {
    return Episode(
        air_date = air_date,
        episode = episode,
        id = id,
        name = name,
    )
}