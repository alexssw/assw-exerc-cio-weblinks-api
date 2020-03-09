version: '3'
services:
  app:
    build:
      context:
      args:
        JAR_FILE: /assw-exerc-cio-weblinks-api-1.0.0.jar
    restart: always
  cassandra:
    image: "cassandra"
