package ru.ildar.yandex.gateway.service

import kotlin.random.Random

class ServiceProvider<T : Health>() {

    val services = mutableSetOf<WeightService<T>>()

    fun getService(): T {
        val healthyServices = services.filter {
            try {
                it.service.getHealth().body?.status == true
            } catch (ignored: Exception) {
                false
            }
        }

        check(healthyServices.isNotEmpty()) { "No healthy services available" }

        val totalWeight = healthyServices.sumOf { it.weight }
        val randomValue = Random.nextInt(1, totalWeight + 1)

        var cumulativeWeight = 0
        healthyServices.forEach { weightService ->
            cumulativeWeight += weightService.weight
            if (randomValue <= cumulativeWeight) {
                return weightService.service
            }
        }

        return healthyServices.last().service
    }

    fun register(service: WeightService<T>) {
        services.add(service)
    }

    data class WeightService<T>(val service: T, val weight: Int)

}
