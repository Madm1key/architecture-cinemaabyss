package ru.ildar.yandex.gateway.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ru.ildar.yandex.gateway.dto.CreatePaymentDto
import ru.ildar.yandex.gateway.dto.PaymentDto
import ru.ildar.yandex.gateway.service.Payment
import ru.ildar.yandex.gateway.service.impl.ServiceProvider

@RestController
class PaymentController(private val serviceProvider: ServiceProvider<Payment>) {

    @GetMapping("/api/payments", params = ["id"])
    fun getPayment(@RequestParam(required = true) id: String): ResponseEntity<PaymentDto> =
        ResponseEntity.ok(serviceProvider.getService().getPayment(id))

    @PostMapping("/api/payments")
    fun createPayment(@RequestBody createPaymentDto: CreatePaymentDto): ResponseEntity<PaymentDto> =
        ResponseEntity.status(HttpStatus.CREATED)
            .body(serviceProvider.getService().createPayment(createPaymentDto))

}
