FROM adoptopenjdk/openjdk11:latest
EXPOSE 8080/tcp
COPY target/ticketTracker-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
