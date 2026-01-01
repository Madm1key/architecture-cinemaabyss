package ru.ildar.yandex.events.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.events.dto.StatusDto

@RestController
class PaymentController {

    @PostMapping("/payment")
    suspend fun createPaymentEvent(): ResponseEntity<StatusDto> =
        ResponseEntity(StatusDto.success(), HttpStatus.CREATED)

}
