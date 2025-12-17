package ru.ildar.yandex.gateway.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.service")
data class ServiceProperties(val movieService: Service, val monolith: Service) {

    data class Service(val url: String)

}
