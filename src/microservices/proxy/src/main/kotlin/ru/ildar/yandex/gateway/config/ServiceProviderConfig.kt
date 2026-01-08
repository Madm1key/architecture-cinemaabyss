package ru.ildar.yandex.gateway.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.ildar.yandex.gateway.properties.GradualProperties
import ru.ildar.yandex.gateway.service.Movie
import ru.ildar.yandex.gateway.service.User
import ru.ildar.yandex.gateway.service.impl.MonolithService
import ru.ildar.yandex.gateway.service.impl.MovieService
import ru.ildar.yandex.gateway.service.impl.ServiceProvider

@Configuration
class ServiceProviderConfig {

    @Bean
    fun movieServiceProvider(
        movieService: MovieService,
        monolithService: MonolithService,
        gradualProperties: GradualProperties
    ): ServiceProvider<Movie> = ServiceProvider<Movie>().apply {
        register(ServiceProvider.WeightService(monolithService, gradualProperties.monolithPercent))
        register(ServiceProvider.WeightService(movieService, gradualProperties.moviePercent))
    }

    @Bean
    fun userServiceProvider(monolithService: MonolithService): ServiceProvider<User> =
        ServiceProvider<User>().apply {
            register(ServiceProvider.WeightService(monolithService, 100))
        }

}
