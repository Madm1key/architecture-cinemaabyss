package ru.ildar.yandex.gateway.dto

data class CreatePaymentDto(
    val userId: Long,
    val amount: Double
)
