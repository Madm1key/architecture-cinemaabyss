package ru.ildar.yandex.gateway.dto

import java.time.Instant

data class CreateSubscriptionDto(
    val userId: Long,
    val planType: String,
    val startDate: Instant,
    val endDate: Instant
)

