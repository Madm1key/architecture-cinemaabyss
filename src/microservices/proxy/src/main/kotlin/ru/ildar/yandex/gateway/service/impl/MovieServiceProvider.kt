package ru.ildar.yandex.gateway.service.impl

import ru.ildar.yandex.gateway.service.Movie
import ru.ildar.yandex.gateway.service.ServiceProvider
import kotlin.random.Random

class MovieServiceProvider : ServiceProvider<Movie> {

    val services = mutableListOf<ServiceProvider.WeightService<Movie>>()

    override fun getService(): Movie = services
        .filter { it.weight < Random.nextInt(1, 11) }
        .last { it.service.getHealth().statusCode.is2xxSuccessful }
        .service

    override fun getDefaultService(): Movie {
        TODO("Not yet implemented")
    }

    override fun register(service: ServiceProvider.WeightService<Movie>) {
        require(service.weight in 1..<11)
        services.add(service);
    }

}
