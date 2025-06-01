FROM openjdk:17-alpine

ENV APP_NAME=seguros-app

WORKDIR /app

COPY ./target/${APP_NAME}.jar ./${APP_NAME}.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "seguros-app.jar"]