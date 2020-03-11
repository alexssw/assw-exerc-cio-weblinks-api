FROM openjdk:8-jdk-alpine
LABEL maintainer="Alexssw"
ARG JAR_FILE=target/assw-exerc-cio-weblinks-api-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]