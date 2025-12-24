package ru.ildar.yandex.gateway.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.gateway.dto.StatusDto

@RestController
class HealthController {

    @GetMapping("/health")
    fun healthCheck(): ResponseEntity<StatusDto> = ResponseEntity.ok(StatusDto(true))

}
