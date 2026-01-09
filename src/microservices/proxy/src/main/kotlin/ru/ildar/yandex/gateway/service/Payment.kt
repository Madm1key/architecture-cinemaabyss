package ru.ildar.yandex.gateway.service

import ru.ildar.yandex.gateway.dto.CreatePaymentDto
import ru.ildar.yandex.gateway.dto.PaymentDto

interface Payment: Health {

    fun getPayment(id: String): PaymentDto

    fun createPayment(payment: CreatePaymentDto): PaymentDto

}
