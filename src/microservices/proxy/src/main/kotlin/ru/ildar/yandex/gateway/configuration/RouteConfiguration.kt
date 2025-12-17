package ru.ildar.yandex.gateway.configuration

import org.springframework.cloud.gateway.server.mvc.filter.BeforeFilterFunctions.uri
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions.route
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions.http
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.function.RequestPredicates.path
import org.springframework.web.servlet.function.RouterFunction
import org.springframework.web.servlet.function.ServerResponse
import ru.ildar.yandex.gateway.properties.ServiceProperties

@Configuration
class RouteConfiguration(private val properties: ServiceProperties) {

    @Bean
    fun gatewayRouterFunctionsAfter(): RouterFunction<ServerResponse> {
        return route("movie-service")
            .route(path("/api/movies/**"), http())
            .before(uri(properties.movieService.url))
            .build().and(
                route("monolith")
                    .route(path("/api/movies/**"), http())
                    .before(uri(properties.monolith.url))
                    .build()
            ).and(
                route("user-service")
                    .route(path("/api/users/**"), http())
                    .before(uri(properties.monolith.url))
                    .build()
            )
    }

}
