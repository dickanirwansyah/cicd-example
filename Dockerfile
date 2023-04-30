FROM adoptopenjdk/openjdk11:latest
EXPOSE 9898
RUN mkdir /app
COPY build/libs/service-job-0.0.1-SNAPSHOT.jar /app/service-job-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/app/service-job-0.0.1-SNAPSHOT.jar"]
