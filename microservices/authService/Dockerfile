FROM openjdk:17
EXPOSE 8070
ADD target/authService-0.0.1-SNAPSHOT.jar user.jar
ENTRYPOINT ["java", "-jar","user.jar"]