package ru.ildar.yandex.gateway.service

import ru.ildar.yandex.gateway.dto.MovieDto

interface Movie : Health {

    fun getMovies(): List<MovieDto>

}
