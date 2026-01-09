package ru.ildar.yandex.gateway.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class PaymentDto(
    val id: Long,
    @JsonProperty("user_id") val userId: Long,
    val amount: Double
)
