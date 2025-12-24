package ru.ildar.yandex.gateway.properties

import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.gradual")
class GradualProperties(enabled: String, movieServicePercent: Int) {

    val movieServicePercent = if (enabled == "true") movieServicePercent else 0

}
