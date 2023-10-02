# Use a compatible gradle image based on project
ARG GRADLE_DOCKER_IMAGE=gradle:8.3
# Use correct compile jvm target version
ARG JAVA_RUNTIME_IMAGE=eclipse-temurin:17-jre-jammy

FROM $GRADLE_DOCKER_IMAGE as TEMP_BUILD_IMAGE
# Copy source files to image and set it as work directory
COPY . /home/gradle/src
WORKDIR /home/gradle/src
# Run bootJar which builds the project into an executable jar file.
RUN gradle bootJar
# Run tests
RUN gradle -x test

# Building a runnable image of the project.
FROM $JAVA_RUNTIME_IMAGE
# Gradle's executable jar output
ARG PROJECT_JAR_FILENAME=java-reactive.jar
COPY --from=TEMP_BUILD_IMAGE /home/gradle/src/build/libs/$PROJECT_JAR_FILENAME app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
