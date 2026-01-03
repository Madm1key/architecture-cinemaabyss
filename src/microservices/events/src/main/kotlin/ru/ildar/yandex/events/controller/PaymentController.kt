package ru.ildar.yandex.events.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.events.dto.StatusDto
import ru.ildar.yandex.events.kafka.EventProducer

@RestController
class PaymentController(private val eventProducer: EventProducer) {

    companion object {
        const val TOPIC = "payment-events"
    }

    @PostMapping("/payment")
    suspend fun createPaymentEvent(@RequestBody body: String): ResponseEntity<StatusDto> {
        eventProducer.sendMessage(TOPIC, body)
        return ResponseEntity(StatusDto.SUCCESS, HttpStatus.CREATED)
    }

}
