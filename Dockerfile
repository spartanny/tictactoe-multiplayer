FROM maven:3-amazoncorretto-20 AS build

# Set the working directory in the container
WORKDIR /app

COPY pom.xml ./
COPY src ./src

RUN mvn install
RUN mvn clean package

FROM openjdk:21-jdk-slim

# Copy the JAR file into the container
COPY target/tic-tac-toe-1.0-SNAPSHOT.jar app.jar


# Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port on which your app runs (e.g., 8080)
EXPOSE 8080
