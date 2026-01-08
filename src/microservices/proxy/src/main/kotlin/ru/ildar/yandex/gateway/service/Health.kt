package ru.ildar.yandex.gateway.service

import ru.ildar.yandex.gateway.dto.StatusDto

fun interface Health {

    fun getHealth(): StatusDto

}
