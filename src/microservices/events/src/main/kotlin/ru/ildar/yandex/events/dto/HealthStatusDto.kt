package ru.ildar.yandex.events.dto

data class HealthStatusDto(val status: Boolean) {

    companion object {
        val OK = HealthStatusDto(true)
    }

}
