#Start with a base image containing Java runtime
FROM openjdk:17 as build

#Information around who maintains the image
MAINTAINER byambadorj.me

# Add the application's jar to the container
COPY target/spring-boot-security-jwt-0.0.1-SNAPSHOT.jar backend-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java","-jar","/backend-0.0.1-SNAPSHOT.jar"]