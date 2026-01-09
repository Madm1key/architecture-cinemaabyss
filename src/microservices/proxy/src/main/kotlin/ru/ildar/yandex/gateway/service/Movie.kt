package ru.ildar.yandex.gateway.service

import ru.ildar.yandex.gateway.dto.CreateMovieDto
import ru.ildar.yandex.gateway.dto.MovieDto

interface Movie : Health {

    fun getMovies(): List<MovieDto>

    fun getMovie(id: String): MovieDto

    fun createMovie(movie: CreateMovieDto): MovieDto

}
