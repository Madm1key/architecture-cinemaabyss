package ru.ildar.yandex.gateway.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.gateway.dto.UserDto
import ru.ildar.yandex.gateway.service.impl.MonolithService

@RestController
class UserController(private val service: MonolithService) {

    @GetMapping("/api/users")
    fun getUsers(): ResponseEntity<List<UserDto>> = ResponseEntity.ok(service.getUsers())

}
