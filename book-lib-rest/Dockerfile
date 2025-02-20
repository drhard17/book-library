FROM openjdk:17-jdk-alpine
RUN mkdir /opt/app
COPY target/book-library-0.0.1-SNAPSHOT.jar /opt/app
EXPOSE 8080
ENTRYPOINT ["java","-jar","/opt/app/book-library-0.0.1-SNAPSHOT.jar"]
