package ru.ildar.yandex.events.kafka

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.SendResult
import org.springframework.stereotype.Component
import java.util.concurrent.CompletableFuture

@Component
class EventProducer(private val kafkaTemplate: KafkaTemplate<String, String>) {

    suspend fun sendMessage(
        topic: String,
        message: String
    ): CompletableFuture<SendResult<String, String>> =
        kafkaTemplate.send(topic, message)

}
