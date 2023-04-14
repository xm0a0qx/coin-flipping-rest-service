FROM openjdk:20-jdk

WORKDIR /app
COPY ./build/libs/coin-flipping-rest-service-0.0.1-SNAPSHOT.jar /app

CMD ["java", "-jar", "coin-flipping-rest-service-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080