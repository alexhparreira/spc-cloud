FROM openjdk:8-jdk-alpine
WORKDIR /usr/src/app
COPY ./target/*.jar /usr/src/app
RUN mv *.jar users-ws.jar
ENTRYPOINT ["/usr/bin/java", "-jar", "-Dspring.profiles.active=prod", "/usr/src/app/users-ws.jar"]