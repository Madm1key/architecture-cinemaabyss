package ru.ildar.yandex.events.dto

data class StatusDto(val status: String) {

    companion object {
        val SUCCESS = StatusDto("success")
    }

}
