FROM maven:3.8.6-amazoncorretto-17 as build
COPY . /usr/src/app
WORKDIR /usr/src/app
RUN mvn -q clean package -DskipTests

FROM amazoncorretto:17
EXPOSE 8080 5005
COPY --from=build /usr/src/app/target /opt/target
WORKDIR /opt/target

ENTRYPOINT ["java", "-jar", "amp-0.0.1-SNAPSHOT.jar"]
