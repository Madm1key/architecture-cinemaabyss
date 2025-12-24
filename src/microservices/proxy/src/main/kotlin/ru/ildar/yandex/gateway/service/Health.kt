package ru.ildar.yandex.gateway.service

import org.springframework.http.ResponseEntity
import ru.ildar.yandex.gateway.dto.StatusDto

fun interface Health {

    fun getHealth(): ResponseEntity<StatusDto>

}
