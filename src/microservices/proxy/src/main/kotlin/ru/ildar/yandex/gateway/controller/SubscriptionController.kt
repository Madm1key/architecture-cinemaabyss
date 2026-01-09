package ru.ildar.yandex.gateway.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.ildar.yandex.gateway.dto.CreateSubscriptionDto
import ru.ildar.yandex.gateway.dto.SubscriptionDto
import ru.ildar.yandex.gateway.service.Subscription
import ru.ildar.yandex.gateway.service.impl.ServiceProvider

@RestController
class SubscriptionController(private val serviceProvider: ServiceProvider<Subscription>) {

    @GetMapping("/api/subscriptions", params = ["id"])
    fun getSubscription(@RequestParam(required = true) id: String): ResponseEntity<SubscriptionDto> =
        ResponseEntity.ok(serviceProvider.getService().getSubscription(id))

    @PostMapping("/api/subscriptions")
    fun createSubscription(@RequestBody createSubscriptionDto: CreateSubscriptionDto): ResponseEntity<SubscriptionDto> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(serviceProvider.getService().createSubscription(createSubscriptionDto))

}
