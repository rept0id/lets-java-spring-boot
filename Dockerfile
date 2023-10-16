FROM openjdk:17-alpine

COPY target/letsjavaspringboot-0.0.1-SNAPSHOT.jar server.jar
ENTRYPOINT ["java","-jar","/server.jar"]
