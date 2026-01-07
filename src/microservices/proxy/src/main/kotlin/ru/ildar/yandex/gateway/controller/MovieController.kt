package ru.ildar.yandex.gateway.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.gateway.dto.MovieDto
import ru.ildar.yandex.gateway.service.Movie
import ru.ildar.yandex.gateway.service.ServiceProvider

@RestController
class MovieController(private val serviceProvider: ServiceProvider<Movie>) {

    @GetMapping("/api/movies")
    fun getMovies(): ResponseEntity<List<MovieDto>> = ResponseEntity.ok(
        serviceProvider.getService().getMovies()
    )

    @GetMapping("/api/movies", params = ["id"])
    fun getMovie(@RequestParam(required = true) id: String): ResponseEntity<MovieDto> =
        ResponseEntity.ok(serviceProvider.getService().getMovie(id))

}
