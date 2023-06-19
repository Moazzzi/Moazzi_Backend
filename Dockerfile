FROM openjdk:11-jre-slim-buster

WORKDIR ./app

COPY build/libs/*.jar ./app.jar
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "-Djasypt.encryptor.password=", "-Dspring.profiles.active=prod", "app.jar"]