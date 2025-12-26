FROM eclipse-temurin:17-jre
WORKDIR /app
COPY . .
RUN ./gradlew build
EXPOSE 8080
CMD ["java", "-jar", "build/libs/*.jar"]
