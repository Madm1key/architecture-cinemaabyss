package ru.ildar.yandex.events.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.events.dto.HealthStatusDto

@RestController
class HealthController {

    @GetMapping("/health")
    suspend fun getHealth(): ResponseEntity<HealthStatusDto> = ResponseEntity.ok(HealthStatusDto.OK)

}
