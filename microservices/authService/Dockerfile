FROM openjdk:17
EXPOSE 8070
ADD target/authService-0.0.1-SNAPSHOT.jar auth.jar
ENTRYPOINT ["java", "-jar","auth.jar"]