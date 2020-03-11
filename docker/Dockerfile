FROM openjdk:10-jre-slim
LABEL maintainer="Alexssw"
ARG JAR_FILE
ADD target/${JAR_FILE} assw-exerc-cio-weblinks-api-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]