# Use a base image without Java
FROM debian:buster-slim

# Install dependencies (if needed)
RUN apt-get update \
    && apt-get install -y curl \
    && rm -rf /var/lib/apt/lists/*

# Download and install Oracle JDK 17
RUN mkdir -p /opt/java \
    && curl -sSL https://download.oracle.com/java/17/latest/jdk-17_linux-x64_bin.tar.gz | tar xz -C /opt/java --strip-components=1

# Set JAVA_HOME and add Java to PATH
ENV JAVA_HOME /opt/java
ENV PATH $JAVA_HOME/bin:$PATH

# Set the working directory inside the container
WORKDIR /app

# Copy your application JAR into the container
COPY demo/target/demo-0.0.1-SNAPSHOT.jar /app/demo.jar

# Specify the command to run your application
CMD ["java", "-jar", "/app/demo.jar"]
