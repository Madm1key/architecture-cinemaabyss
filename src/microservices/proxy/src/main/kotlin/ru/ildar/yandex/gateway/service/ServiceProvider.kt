package ru.ildar.yandex.gateway.service

interface ServiceProvider<T> {

    fun getService(): T

    fun getDefaultService(): T

    fun register(service: WeightService<T>)

    data class WeightService<T>(val service: T, val weight: Int)

}
