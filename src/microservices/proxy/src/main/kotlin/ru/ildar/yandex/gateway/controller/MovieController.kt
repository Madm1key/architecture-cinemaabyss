package ru.ildar.yandex.gateway.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.ildar.yandex.gateway.dto.CreateMovieDto
import ru.ildar.yandex.gateway.dto.MovieDto
import ru.ildar.yandex.gateway.dto.StatusDto
import ru.ildar.yandex.gateway.service.Movie
import ru.ildar.yandex.gateway.service.impl.ServiceProvider

@RestController
class MovieController(private val serviceProvider: ServiceProvider<Movie>) {

    @GetMapping("/api/movies/health")
    fun getHealth(): ResponseEntity<StatusDto> = serviceProvider.getService().getHealth()

    @GetMapping("/api/movies")
    fun getMovies(): ResponseEntity<List<MovieDto>> = ResponseEntity.ok(
        serviceProvider.getService().getMovies()
    )

    @GetMapping("/api/movies", params = ["id"])
    fun getMovie(@RequestParam(required = true) id: String): ResponseEntity<MovieDto> =
        ResponseEntity.ok(serviceProvider.getService().getMovie(id))

    @PostMapping("/api/movies")
    fun createMovie(@RequestBody createMovieDto: CreateMovieDto): ResponseEntity<MovieDto> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(serviceProvider.getService().createMovie(createMovieDto))

}
