package ru.ildar.yandex.gateway.dto

data class CreateMovieDto(
    val title: String,
    val description: String,
    val genres: List<String>,
    val rating: Double
)
