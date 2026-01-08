package ru.ildar.yandex.gateway.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.ildar.yandex.gateway.dto.CreateUserDto
import ru.ildar.yandex.gateway.dto.UserDto
import ru.ildar.yandex.gateway.service.User
import ru.ildar.yandex.gateway.service.impl.ServiceProvider

@RestController
class UserController(private val serviceProvider: ServiceProvider<User>) {

    @GetMapping("/api/users")
    fun getUsers(): ResponseEntity<List<UserDto>> = ResponseEntity.ok(
        serviceProvider.getService().getUsers()
    )

    @GetMapping("/api/users", params = ["id"])
    fun getUser(@RequestParam(required = true) id: String): ResponseEntity<UserDto> =
        ResponseEntity.ok(serviceProvider.getService().getUser(id))

    @PostMapping("/api/users")
    fun createUser(@RequestBody createUserDto: CreateUserDto): ResponseEntity<UserDto> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(serviceProvider.getService().createUser(createUserDto))

}
