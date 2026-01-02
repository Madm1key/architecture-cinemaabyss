package ru.ildar.yandex.events.controller

import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.events.dto.StatusDto
import ru.ildar.yandex.events.kafka.EventProducer

@RestController
class PaymentController(private val eventProducer: EventProducer) {

    companion object {
        private val logger = LoggerFactory.getLogger(PaymentController::class.java)
        const val TOPIC = "payment-events"
    }

    @PostMapping("/payment")
    suspend fun createPaymentEvent(): ResponseEntity<StatusDto> {
        eventProducer.sendMessage(TOPIC, "hello").thenAccept {
            logger.info("it $it")
        }
        return ResponseEntity(StatusDto.SUCCESS, HttpStatus.CREATED)
    }

}
