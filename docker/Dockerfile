FROM openjdk:8-jdk-alpine
RUN apk add --update
COPY build/libs/*.jar /usr/src/app/assw-exerc-cio-weblinks-api.jar
WORKDIR /usr/src/app
ENV JAVA_OPTS="-Dspring.profiles.active=local"
ENTRYPOINT["/usr/bin/java"]
CMD["-jar","/usr/src/app/assw-exerc-cio-weblinks-api.jar"]
EXPOSE 8080