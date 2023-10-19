FROM openjdk:8
LABEL authors="wchen"

ADD ./target/*.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]