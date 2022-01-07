cd Docker
REM Remove old container and image.
docker stop lucid-sams
docker rm lucid-sams
docker rmi sfy/lucid-sams

rm pumbaa-service-layer-core-1.0-SNAPSHOT.jar
copy ..\service-layer\target\pumbaa-service-layer-core-1.0-SNAPSHOT.jar .

REM Create new image.
docker build . -t sfy/lucid-sams

REM Start container.
docker run -d -p 5432:5432 -p 58080:8081 --restart unless-stopped --name lucid-sams sfy/lucid-sams
