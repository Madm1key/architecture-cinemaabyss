package ru.ildar.yandex.gateway.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.gateway.dto.StatusDto
import ru.ildar.yandex.gateway.service.Health

@RestController
class HealthController : Health {

    @GetMapping("/health")
    override fun getHealth(): ResponseEntity<StatusDto> = ResponseEntity.ok(StatusDto(true))

}
