package ru.ildar.yandex.events.kafka

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.ildar.yandex.events.controller.MovieController
import ru.ildar.yandex.events.controller.PaymentController
import ru.ildar.yandex.events.controller.UserController

@Component
class EventConsumer {

    companion object {
        private val logger: Logger = LoggerFactory.getLogger(EventConsumer::class.java)
    }

    @KafkaListener(
        id = "events",
        topics = [MovieController.TOPIC, PaymentController.TOPIC, UserController.TOPIC]
    )
    suspend fun listen(value: String?) {
        logger.info("Event payload: {}", value)
    }

}
