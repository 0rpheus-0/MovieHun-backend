FROM maven:3-eclipse-temurin-21-alpine AS build

WORKDIR /app

COPY checkstyle.xml pom.xml ./
RUN mvn clean verify --fail-never -DskipTests
COPY src ./src
RUN mvn package -DskipTests

FROM eclipse-temurin:21-alpine
WORKDIR /app

COPY --from=build /app/target/javalabs-0.0.1-SNAPSHOT.jar javalabs.jar

CMD ["java", "-jar", "javalabs.jar"]