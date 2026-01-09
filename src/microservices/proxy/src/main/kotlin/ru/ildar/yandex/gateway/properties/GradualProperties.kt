package ru.ildar.yandex.gateway.properties

import jakarta.annotation.PostConstruct
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.boot.context.properties.ConfigurationProperties

@ConfigurationProperties(prefix = "app.gradual")
class GradualProperties(enabled: String, movieServicePercent: Int) {

    companion object {
        val log: Logger = LoggerFactory.getLogger(GradualProperties::class.java)
    }

    val moviePercent = if (enabled == "true") movieServicePercent else 100
    val monolithPercent = 100 - moviePercent

    override fun toString(): String {
        return "MoviePercent: $moviePercent; MonolithPercent $monolithPercent"
    }

    @PostConstruct
    fun postConstruct() {
        log.info(toString())
    }

}
