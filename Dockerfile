FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

COPY . .

CMD ["./mvn", "spring-boot:run"]
