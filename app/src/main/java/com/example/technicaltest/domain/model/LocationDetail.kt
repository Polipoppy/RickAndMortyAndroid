package com.example.technicaltest.domain.model

data class LocationDetail(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
)