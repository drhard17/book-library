FROM openjdk:17-jdk-alpine
VOLUME /tmp
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} BookLibraryApplication.jar
ENTRYPOINT ["java","-jar","/BookLibraryApplication.jar"]

