package ru.ildar.yandex.events.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class KafkaConfig {

    companion object {
        const val EVENTS_TOPIC = "events"
    }

    @Bean
    fun topic() = NewTopic(EVENTS_TOPIC, 1, 1)

}
