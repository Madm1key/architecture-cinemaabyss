package ru.ildar.yandex.gateway.service.impl

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.service.annotation.GetExchange
import org.springframework.web.service.annotation.PostExchange
import ru.ildar.yandex.gateway.dto.*
import ru.ildar.yandex.gateway.service.Movie
import ru.ildar.yandex.gateway.service.Payment
import ru.ildar.yandex.gateway.service.Subscription
import ru.ildar.yandex.gateway.service.User

interface MonolithService : Movie, User, Payment, Subscription {

    @GetExchange("/health")
    override fun getHealth(): ResponseEntity<StatusDto>

    @GetExchange("/api/movies")
    override fun getMovies(): List<MovieDto>

    @GetExchange("/api/movies")
    override fun getMovie(@RequestParam id: String): MovieDto

    @PostExchange("/api/movies")
    override fun createMovie(@RequestBody movie: CreateMovieDto): MovieDto

    @GetExchange("/api/users")
    override fun getUsers(): List<UserDto>

    @GetExchange("/api/users")
    override fun getUser(@RequestParam id: String): UserDto

    @PostExchange("/api/users")
    override fun createUser(@RequestBody user: CreateUserDto): UserDto

    @GetExchange("/api/payments")
    override fun getPayment(@RequestParam id: String): PaymentDto

    @PostExchange("/api/payments")
    override fun createPayment(@RequestBody payment: CreatePaymentDto): PaymentDto

    @GetExchange("/api/payments")
    override fun getSubscription(@RequestParam id: String): SubscriptionDto

    @PostExchange("/api/payments")
    override fun createSubscription(@RequestBody payment: CreateSubscriptionDto): SubscriptionDto

}
