package ru.ildar.yandex.gateway.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class CreatePaymentDto(
    @JsonProperty("user_id") val userId: Long,
    val amount: Double
)
