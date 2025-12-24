package ru.ildar.yandex.gateway.service

import org.springframework.web.service.annotation.GetExchange
import ru.ildar.yandex.gateway.dto.MovieDto
import ru.ildar.yandex.gateway.dto.StatusDto
import ru.ildar.yandex.gateway.dto.UserDto

interface MonolithService {

    @GetExchange("/api/movies")
    fun getMovies(): List<MovieDto>

    @GetExchange("/health")
    fun getHealth(): StatusDto

    @GetExchange("/api/users")
    fun getUsers(): List<UserDto>

}
