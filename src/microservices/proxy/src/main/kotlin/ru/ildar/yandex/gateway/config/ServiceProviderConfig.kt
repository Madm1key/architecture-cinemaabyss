package ru.ildar.yandex.gateway.config

import org.apache.catalina.User
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.ildar.yandex.gateway.service.Movie
import ru.ildar.yandex.gateway.service.ServiceProvider
import ru.ildar.yandex.gateway.service.impl.MonolithService
import ru.ildar.yandex.gateway.service.impl.MovieService
import ru.ildar.yandex.gateway.service.impl.MovieServiceProvider

@Configuration
class ServiceProviderConfig {

    @Bean
    fun movieServiceProvider(
        movieService: MovieService,
        monolithService: MonolithService
    ): ServiceProvider<Movie> = MovieServiceProvider().apply {
            register(ServiceProvider.WeightService(movieService, 5))
            register(ServiceProvider.WeightService(monolithService, 5))
        }

    @Bean
    fun userServiceProvider(): ServiceProvider<User>? = null

}
