package ru.ildar.yandex.gateway.service

import ru.ildar.yandex.gateway.dto.UserDto

interface User : Health {

    fun getUsers(): List<UserDto>

}
