FROM maven:3.9-eclipse-temurin-8

WORKDIR /app

COPY pom.xml testng.xml ./
RUN mvn -B dependency:go-offline

COPY src ./src

ENTRYPOINT ["mvn", "-B", "clean", "test"]
