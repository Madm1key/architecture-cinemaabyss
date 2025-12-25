package ru.ildar.yandex.gateway.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.gradual")
class GradualProperties(enabled: String, movieServicePercent: Int) {

    val moviePercent = if (enabled == "true") movieServicePercent else 0
    val monolithPercent = 100 - moviePercent

}
