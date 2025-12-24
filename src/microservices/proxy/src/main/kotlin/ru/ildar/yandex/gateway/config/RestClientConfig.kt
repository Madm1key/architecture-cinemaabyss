package ru.ildar.yandex.gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import ru.ildar.yandex.gateway.properties.ServiceProperties

@Configuration
class RestClientConfig(private val serviceProperties: ServiceProperties) {

    @Bean
    fun monolithClient(builder: RestClient.Builder): RestClient {
        return builder.baseUrl(serviceProperties.monolith.url).build()
    }

    @Bean
    fun moviesClient(builder: RestClient.Builder): RestClient {
        return builder.baseUrl(serviceProperties.movieService.url).build()
    }

}
