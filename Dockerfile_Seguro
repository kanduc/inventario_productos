# Etapa 1: Build
FROM maven:3.8.5-eclipse-temurin-17 AS builder
WORKDIR /app
COPY pom.xml ./
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Imagen final
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Crear usuario no root
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

# Copiar JAR y asignar permisos
COPY --from=builder /app/target/*.jar app.jar
RUN chown -R appuser:appgroup /app

# Cambiar a usuario seguro
USER appuser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
