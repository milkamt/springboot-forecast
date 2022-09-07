FROM openjdk:8-jdk-alpine
WORKDIR /forecast
COPY . .
RUN chmod +x ./gradlew build
ENTRYPOINT [ "java", "-jar", "build/libs/*.jar" ]