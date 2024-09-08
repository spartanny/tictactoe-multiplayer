# Use the official OpenJDK image from the Docker Hub
FROM openjdk:24-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/tic-tac-toe-1.0-SNAPSHOT.jar app.jar

# Specify the command to run the JAR file
ENTRYPOINT ["java", "-jar", "app.jar"]

# Expose the port on which your app runs (e.g., 8080)
EXPOSE 8080
