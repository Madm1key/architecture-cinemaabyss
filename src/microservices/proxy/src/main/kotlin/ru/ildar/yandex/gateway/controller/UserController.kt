package ru.ildar.yandex.gateway.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.gateway.dto.UserDto
import ru.ildar.yandex.gateway.service.ServiceProvider
import ru.ildar.yandex.gateway.service.User

@RestController
class UserController(private val serviceProvider: ServiceProvider<User>) {

    @GetMapping("/api/users")
    fun getUsers(): ResponseEntity<List<UserDto>> = ResponseEntity.ok(
        serviceProvider.getService().getUsers()
    )

}
