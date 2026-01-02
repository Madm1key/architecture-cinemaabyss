package ru.ildar.yandex.events.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component
import ru.ildar.yandex.events.config.KafkaConfig

@Component
class EventProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

    fun sendMessage(message: String) = kafkaTemplate.send(KafkaConfig.EVENTS_TOPIC, message);

}
