version: '3'
services:
  app:
    build:
      context:
      args:
        JAR_FILE: /assw-exerc-cio-weblinks-api-0.0.1-SNAPSHOT.jar
    restart: always
  cassandra:
    image: "cassandra"
