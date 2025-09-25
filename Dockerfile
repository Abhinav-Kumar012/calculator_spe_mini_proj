FROM maven:3.9.11-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY calc/ .

RUN mvn clean install

FROM eclipse-temurin:21-jre-alpine

COPY --from=build /app/target/calc-1.0-SNAPSHOT.jar .

CMD ["java","-jar","calc-1.0-SNAPSHOT.jar"]