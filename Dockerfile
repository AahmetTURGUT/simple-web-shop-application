FROM openjdk:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} simple-web-shop-application-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "jar", "/simple-web-shop-application-0.0.1-SNAPSHOT.jar"]