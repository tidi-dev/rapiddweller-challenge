# Use the official OpenJDK 21 image as the base image
FROM openjdk:21-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Gradle files to the container
COPY build.gradle.kts .
COPY settings.gradle.kts .

# Copy the entire source code to the container
COPY src src
COPY .env .env

# Install necessary tools (curl, unzip)
RUN apt-get update && \
    apt-get install -y --no-install-recommends curl unzip && \
    rm -rf /var/lib/apt/lists/*

# Install Gradle
RUN curl -sSL https://services.gradle.org/distributions/gradle-8.5-bin.zip -o gradle.zip && \
    unzip -q gradle.zip && \
    rm gradle.zip && \
    mv gradle-* gradle

# Build the application with Gradle
RUN ./gradle/bin/gradle clean build

# Expose the port that the application will run on
EXPOSE 8080

# Set the default command to run the application
#CMD ["java", "-jar", "build/libs/rapiddweller-0.0.1-SNAPSHOT.jar"]
CMD ["./gradle/bin/gradle", "bootRun"]

