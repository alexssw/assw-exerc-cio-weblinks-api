FROM openjdk:8-jdk-alpine
RUN apk add --update
ARG JAR_FILE
COPY ${JAR_FILE} /usr/src/app/assw-exerc-cio-weblinks-api.jar
WORKDIR /usr/src/app
ENV JAVA_OPTS="-Dspring.profiles.active=local"
EXPOSE 8080
CMD java -jar /usr/src/app/assw-exerc-cio-weblinks-api.jar