package ru.ildar.yandex.gateway.service.impl

import org.springframework.http.ResponseEntity
import org.springframework.web.service.annotation.GetExchange
import ru.ildar.yandex.gateway.dto.MovieDto
import ru.ildar.yandex.gateway.dto.StatusDto
import ru.ildar.yandex.gateway.service.Movie

interface MovieService : Movie {

    @GetExchange("/api/movies/health")
    override fun getHealth(): ResponseEntity<StatusDto>

    @GetExchange("/api/movies")
    override fun getMovies(): List<MovieDto>

}
