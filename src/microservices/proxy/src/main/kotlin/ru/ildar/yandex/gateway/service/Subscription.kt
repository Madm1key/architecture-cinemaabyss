package ru.ildar.yandex.gateway.service

import ru.ildar.yandex.gateway.dto.CreateSubscriptionDto
import ru.ildar.yandex.gateway.dto.SubscriptionDto

interface Subscription : Health {

    fun getSubscription(id: String): SubscriptionDto

    fun createSubscription(payment: CreateSubscriptionDto): SubscriptionDto

}
