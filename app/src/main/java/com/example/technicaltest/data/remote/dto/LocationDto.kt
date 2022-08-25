package com.example.technicaltest.data.remote.dto

import com.example.technicaltest.domain.model.Location

data class LocationDto(
    val name: String,
)

fun LocationDto.toLocation(): Location {
    return Location(
        name = name,
    )
}