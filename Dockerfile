# ---- Build stage ----
FROM eclipse-temurin:23-jdk AS build
WORKDIR /app
COPY . .
RUN chmod +x mvnw
RUN ./mvnw clean package -DskipTests

# ---- Run stage (JRE only, not JDK) ----
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=build /app/target/guesstheword-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Cap heap so the JVM never tries to exceed Render free tier's 512MB
ENTRYPOINT ["sh", "-c", "java -Xmx256m -Xss512k -XX:+UseSerialGC -Dserver.port=${PORT:-8080} -jar app.jar"]
