FROM openjdk:11-jre-slim

COPY build/libs/proxy-server-1.0.jar proxy-server-1.0.jar

ENV APP_NAME=proxy-server

ENTRYPOINT ["java","-jar","/proxy-server-1.0.jar"]