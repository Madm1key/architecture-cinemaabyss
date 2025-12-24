package ru.ildar.yandex.gateway.dto

data class MovieDto(
    val id: Long,
    val title: String,
    val description: String,
    val genres: List<String>,
    val rating: Double
)
