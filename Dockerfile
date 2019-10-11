FROM openjdk:8-jdk-alpine
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app
COPY target/mavha-challenge-be-0.0.1-SNAPSHOT.jar mavha-challenge-be-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=prod","mavha-challenge-be-0.0.1-SNAPSHOT.jar"]