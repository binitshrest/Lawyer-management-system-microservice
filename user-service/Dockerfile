FROM maven:3.9.9-eclipse-temurin-21 AS builder
### Add working directory as app
WORKDIR /app

COPY pom.xml .
COPY common-contract/pom.xml common-contract/pom.xml
COPY user-service/pom.xml user-service/pom.xml
COPY lawyer-service/pom.xml lawyer-service/pom.xml
COPY rating-service/pom.xml rating-service/pom.xml
RUN mvn -q -B -DskipTests dependency:go-offline

#Build
COPY . .
RUN mvn -q -B -DskipTests -pl user-service -am clean package


FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=builder /app/user-service/target/user-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9010
ENTRYPOINT ["java","-jar","/app/app.jar"]
