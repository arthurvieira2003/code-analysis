FROM maven:3.9.5-eclipse-temurin-21

WORKDIR /app
COPY . .

RUN mvn clean package

EXPOSE 8080
CMD ["java", "-jar", "target/code-analysis-1.0-SNAPSHOT.jar"]