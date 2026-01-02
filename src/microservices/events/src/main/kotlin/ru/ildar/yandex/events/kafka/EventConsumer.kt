package ru.ildar.yandex.events.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component
import ru.ildar.yandex.events.controller.MovieController
import ru.ildar.yandex.events.controller.PaymentController
import ru.ildar.yandex.events.controller.UserController

@Component
class EventConsumer {

    @KafkaListener(
        id = "events",
        topics = [MovieController.TOPIC, PaymentController.TOPIC, UserController.TOPIC]
    )
    suspend fun listen(value: String?) {
        println(value)
    }

}
