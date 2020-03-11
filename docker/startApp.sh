#!/bin/bash
docker build --build-arg JAR_FILE=../build/libs/*.jar \
  --tag=weblinks/assw-exerc-cio-weblinks-api-docker \
  --rm=true .

docker volume create --name=assw-exerc-cio-weblinks-api-repo
docker run --name=weblinks/assw-exerc-cio-weblinks-api-docker  --publish=8080:8080 \
     --volume=assw-exerc-cio-weblinks-api-repo:/var/lib/assw-exerc-cio-weblinks-api-repo/config-repo \
     weblinks/assw-exerc-cio-weblinks-api-docker:lasted