package ru.ildar.yandex.gateway.dto

data class PaymentDto(
    val id: Long,
    val userId: Long,
    val amount: Double
)
