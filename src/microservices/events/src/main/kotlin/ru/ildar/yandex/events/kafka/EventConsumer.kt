package ru.ildar.yandex.events.kafka

import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class EventConsumer {

    @KafkaListener(id = "events", topics = ["events"])
    fun listen(value: String?) {
        println(value)
    }

}
