# Use Maven image to build the JAR
FROM maven:latest AS build
WORKDIR /app

# Copy the source code into the container
COPY . .

# Build the JAR file
RUN mvn clean package

# Use a lightweight JDK image to run the application
FROM openjdk:17-slim
WORKDIR /app

# Copy the built JAR from the previous stage
COPY --from=build /app/target/BPMS-demo-1.0-SNAPSHOT.jar .

# Run the application
CMD ["java", "-jar", "BPMS-demo-1.0-SNAPSHOT.jar"]