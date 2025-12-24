package ru.ildar.yandex.gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.client.RestClient
import org.springframework.web.client.support.RestClientAdapter
import org.springframework.web.service.invoker.HttpServiceProxyFactory
import org.springframework.web.service.invoker.createClient
import ru.ildar.yandex.gateway.service.MonolithService
import ru.ildar.yandex.gateway.service.MovieService

@Configuration
class ServiceConfig(private val monolithClient: RestClient, private val moviesClient: RestClient) {

    @Bean
    fun monolithService(): MonolithService {
        return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(monolithClient)).build()
            .createClient<MonolithService>()
    }

    @Bean
    fun moviesService(): MovieService {
        return HttpServiceProxyFactory.builderFor(RestClientAdapter.create(moviesClient)).build()
            .createClient<MovieService>()
    }

}
