FROM openjdk:17-alpine
WORKDIR /forecast
COPY . .
RUN chmod +x ./gradlew
ENTRYPOINT [ "java", "-jar", "build/libs/spring-boot-forecast-0.0.1-SNAPSHOT.jar" ]