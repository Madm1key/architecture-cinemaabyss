package ru.ildar.yandex.gateway.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.Instant

data class CreateSubscriptionDto(
    @JsonProperty("user_id") val userId: Long,
    @JsonProperty("plan_type") val planType: String,
    @JsonProperty("start_date") val startDate: Instant,
    @JsonProperty("end_date") val endDate: Instant
)

