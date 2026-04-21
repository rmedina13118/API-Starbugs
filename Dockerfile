FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/capstone-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} capstone-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "capstone-0.0.1-SNAPSHOT.jar"]