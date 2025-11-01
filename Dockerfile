# ======================================
# Build Stage
# ======================================
FROM maven:3-eclipse-temurin-25 AS builder

WORKDIR /app

# Copy Maven descriptor & resolve dependencies
COPY pom.xml .
RUN mvn -B dependency:go-offline

# Copy full source directory & build the JAR
COPY src ./src
RUN mvn -B clean package -DskipTests

# ======================================
# Runtime Stage
# ======================================
FROM eclipse-temurin:25-jre AS runtime

WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# JVM memory tuning
ENV JAVA_OPTS="-Xms256m -Xmx512m"

EXPOSE 8080

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]
