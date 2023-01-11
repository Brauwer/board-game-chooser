# syntax=docker/dockerfile:1
FROM openjdk:17
MAINTAINER  Thomas De Brauwer <thomasdebrauwer96@gmail.com>
COPY ./target/boardgamechooser-0.0.1-SNAPSHOT.jar boardgamechooser-backend.jar
ENTRYPOINT ["java","-jar","boardgamechooser-backend.jar"]