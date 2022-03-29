#!/bin/bash

export JAVA_HOME=$JAVA8_HOME
cd ../;
mvn clean install -DskipTests;

cd Docker;
#Remove old container and image.
docker stop lucid-sams; docker rm lucid-sams;
docker rmi sfy/lucid-sams;

rm lucid-sams-core-1.0-SNAPSHOT.jar;
cp ../core/target/lucid-sams-core-1.0-SNAPSHOT.jar .
#Create new image.
docker build . -t sfy/lucid-sams;

#Start container.
docker run -d -p 8089:8088 --restart unless-stopped --name lucid-sams sfy/lucid-sams;
