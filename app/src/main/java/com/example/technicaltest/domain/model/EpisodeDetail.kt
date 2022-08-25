package com.example.technicaltest.domain.model

data class EpisodeDetail(
    val air_date: String,
    val characters: List<String>,
    val created: String,
    val episode: String,
    val id: Int,
    val name: String,
)