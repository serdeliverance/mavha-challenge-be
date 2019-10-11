# mavha-challenge-todo-be-spring

Mavha Challenge backend project built on Spring Boot with Postgres and Docker. It also contains and adminer UI for looking at the DBs data.

## Pre requisites

```
Jdk 1.8
Maven 3.x
Docker
Docker-compose
```

## Development server

Run `mvn spring-boot:run -Dspring.profiles.active=dev` for a dev server. It will start up the application using and in-memory database with some dummy data. The application would be running on `http://localhost:8080/`.

## Run with Docker-compose (need to fix issues, don't use it)

First, create a docker network with the follow command (you'll only need to do that once):

`docker network create --driver bridge mavha-be`

To run the application in a more realistic environment using docker, execute the following commands:

```
mvn clean install
docker-compose build
docker-compose up
```

It will build the app and then it will build a docker image based on our build. In addition, docker compose contains Postgresql configured.

## Postman collection with all the enpoints

Check postman-collections folder and import its collection into postman to test the API.

## Notes

* (for docker users) Uploaded files are storage on fileSystem inside the mavha-be docker container and It has not a volume defined yet. So, after stopping the container, files will be discard.

* (for docker users) You can explore the app's data using the adminer, which is running on `http://localhost:8080/`. Check docker-compose.yml for credentials.

* Search/filter functionality is not implemented on the frontend but it's on the backend API.
