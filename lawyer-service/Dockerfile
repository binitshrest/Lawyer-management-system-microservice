FROM maven:3.9.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY common-contract/pom.xml common-contract/pom.xml
COPY user-service/pom.xml user-service/pom.xml
COPY lawyer-service/pom.xml lawyer-service/pom.xml
COPY rating-service/pom.xml rating-service/pom.xml
RUN mvn -q -B -DskipTests dependency:go-offline
COPY . .
RUN mvn -q -B -DskipTests -pl lawyer-service -am clean package

FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/lawyer-service/target/lawyer-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9020
ENTRYPOINT ["java","-jar","/app/app.jar"]