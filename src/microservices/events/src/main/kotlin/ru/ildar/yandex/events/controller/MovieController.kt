package ru.ildar.yandex.events.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import ru.ildar.yandex.events.dto.StatusDto
import ru.ildar.yandex.events.kafka.EventProducer

@RestController
class MovieController(private val eventProducer: EventProducer) {

    companion object {
        const val TOPIC = "movie-events"
    }

    @PostMapping("/movie")
    suspend fun createMovieEvent(): ResponseEntity<StatusDto> {
        eventProducer.sendMessage(TOPIC, "hello")
        return ResponseEntity(StatusDto.SUCCESS, HttpStatus.CREATED)
    }

}
