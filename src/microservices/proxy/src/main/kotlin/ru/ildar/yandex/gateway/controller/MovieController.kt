package ru.ildar.yandex.gateway.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.gateway.dto.MovieDto
import ru.ildar.yandex.gateway.service.MonolithService
import ru.ildar.yandex.gateway.service.MovieService
import kotlin.random.Random

@RestController
class MovieController(
    private val monolithService: MonolithService,
    private val movieService: MovieService
) {

    @GetMapping("/api/movies")
    fun getMovies(): ResponseEntity<List<MovieDto>> {
        if (!movieService.getHealth().status) {
            return ResponseEntity.ok(monolithService.getMovies())
        }

        if (!monolithService.getHealth().status) {
            return ResponseEntity.ok(movieService.getMovies())
        }

        val useMicroservice = Random.nextInt(1, 11) < 6
        return if (useMicroservice) {
            ResponseEntity.ok(movieService.getMovies())
        } else {
            ResponseEntity.ok(monolithService.getMovies())
        }
    }

}
