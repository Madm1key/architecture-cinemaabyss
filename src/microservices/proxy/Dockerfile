FROM gradle:jdk21-alpine AS builder
WORKDIR /app
COPY src ./src
COPY build.gradle ./build.gradle
RUN gradle bootJar

FROM amazoncorretto:21-alpine3.22-jdk AS backend
WORKDIR /root
COPY --from=builder /app/build/libs/app.jar ./
EXPOSE 8000
ENTRYPOINT ["java", "-jar", "app.jar"]
