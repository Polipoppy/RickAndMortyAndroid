package com.example.technicaltest.data.remote.dto

import com.example.technicaltest.domain.model.LocationDetail

data class LocationDetailDto(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
)

fun LocationDetailDto.toLocationDetail(): LocationDetail {
    return LocationDetail(
        created = created,
        dimension = dimension,
        id = id,
        name = name,
        residents = residents,
        type = type,
    )
}