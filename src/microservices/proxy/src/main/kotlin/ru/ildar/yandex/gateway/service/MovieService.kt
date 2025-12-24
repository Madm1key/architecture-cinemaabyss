package ru.ildar.yandex.gateway.service

import org.springframework.web.service.annotation.GetExchange
import ru.ildar.yandex.gateway.dto.MovieDto
import ru.ildar.yandex.gateway.dto.StatusDto

interface MovieService {

    @GetExchange("/api/movies/health")
    fun getHealth(): StatusDto

    @GetExchange("/api/movies")
    fun getMovies(): List<MovieDto>

}
