FROM openjdk:17
EXPOSE 8055
ADD target/promotion-0.0.1-SNAPSHOT.jar promotion.jar
ENTRYPOINT ["java", "-jar","promotion.jar"]