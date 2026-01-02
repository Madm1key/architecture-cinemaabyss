FROM gradle:jdk21-alpine AS builder
WORKDIR /app
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN --mount=type=cache,target=/root/.gradle gradle bootJar

FROM amazoncorretto:21-alpine3.22-jdk AS backend
WORKDIR /root
COPY --from=builder /app/build/libs/app.jar ./
EXPOSE 8082
ENTRYPOINT ["java", "-jar", "app.jar"]
