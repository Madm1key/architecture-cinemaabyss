package ru.ildar.yandex.events.dto

data class StatusDto(val status: String) {

    companion object {
        fun success(): StatusDto = StatusDto("success")
        fun fail(): StatusDto = StatusDto("fail")
    }

}
