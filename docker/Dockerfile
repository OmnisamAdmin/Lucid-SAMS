FROM openjdk:8-alpine
USER root
RUN apk add gnupg;
RUN apk add tzdata;
RUN cp /usr/share/zoneinfo/Africa/Johannesburg /etc/localtime

COPY lucid-sams-core-1.0-SNAPSHOT.jar app.jar

EXPOSE 8088
# Start the docker container with the following entrypoint.
ENTRYPOINT ["java", "-jar", "/app.jar"]
# To Debug
#EXPOSE 5005
#ENTRYPOINT ["java", "-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=*:5005", "-jar","/app.jar"]
