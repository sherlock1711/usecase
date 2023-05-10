FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/usecase-0.0.1-SNAPSHOT.jar usecase.jar
ENTRYPOINT ["java","-jar","/usecase.jar"]