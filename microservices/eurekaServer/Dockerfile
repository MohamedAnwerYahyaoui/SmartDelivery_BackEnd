FROM openjdk:17
EXPOSE 8076
ADD target/eurekaServer-0.0.1-SNAPSHOT.jar eureka.jar
ENTRYPOINT ["java", "-jar","eureka.jar"]