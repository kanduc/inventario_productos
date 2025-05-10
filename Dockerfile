# Etapa 1: Construccion
FROM maven:3.8.5-openjdk-17 AS builder
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests


# Etapa 2: Imagen final
FROM openjdk:17.0.2
WORKDIR /app
COPY --from=builder /app/target/inventario-productos-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
