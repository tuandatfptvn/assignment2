FROM eclipse-temurin:17-jdk-alpine as build
WORKDIR /app
ARG SERVICE_DIR
COPY ${SERVICE_DIR}/pom.xml .
COPY ${SERVICE_DIR}/src ./src
RUN apk add --no-cache maven
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
