FROM openjdk:8-jdk-alpine
WORKDIR /forecast
COPY . .
RUN ./gradlew build
ENTRYPOINT [ "java", "-jar", "build/libs/*.jar" ]