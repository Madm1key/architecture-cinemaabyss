package ru.ildar.yandex.gateway.service.impl

import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange
import ru.ildar.yandex.gateway.dto.CreateMovieDto
import ru.ildar.yandex.gateway.dto.MovieDto
import ru.ildar.yandex.gateway.dto.StatusDto
import ru.ildar.yandex.gateway.service.Movie

interface MovieService : Movie {

    @GetExchange("/api/movies/health")
    override fun getHealth(): StatusDto

    @GetExchange("/api/movies")
    override fun getMovies(): List<MovieDto>

    @GetExchange("/api/movies")
    override fun getMovie(@RequestParam id: String): MovieDto

    @PostExchange("/api/movies")
    override fun createMovie(@RequestBody movie: CreateMovieDto): MovieDto

}
