# Microservice Promotion

Microservice CRUD pour la gestion des promotions avec intégration Spring Cloud.

## 🛠️ Stack Technique
- **Framework** : Spring Boot 3.x
- **Service Discovery** : Eureka
- **API Gateway** : Spring Cloud Gateway
- **Configuration** : Spring Cloud Config
- **Base de données** : Mysql (conteneurisé)
- **Containerisation** : Docker + Docker Compose

🔧 Configuration
bootstrap.yml:


#config
spring.cloud.config.enabled=true
management.endpoints.web.exposure.include=refresh,health,info
spring.config.import=optional:configserver:http://localhost:8888/


server.port=8076
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false


🐳 Docker Integration
Dockerfile optimisé :

dockerfile
FROM openjdk:17
EXPOSE 8082
ADD target/Client-0.0.1-SNAPSHOT.jar client.jar
ENTRYPOINT ["java", "-jar","client.jar"]
services:
  spring.application.name=config-server
server.port=8888
#eureka registration
eureka.client.service-url.defaultZone=http://localhost:8076/eureka
eureka.client.register-with-eureka=true
#mode local
spring.profiles.active=native
spring.cloud.config.server.native.search-locations=classpath:/config
📦 Dependencies Clés
xml

<!-- Spring Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Data MongoDB -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-mongodb</artifactId>
</dependency>

<!-- Validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>

<!-- Eureka Client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>


📄 License
MIT License


Points clés de ce README :
1. Configuration MongoDB conteneurisée
2. Healthcheck intégré dans Docker
3. Profils Spring distincts (dev/docker)
4. Exemples complets pour les requêtes API
5. Intégration claire avec les autres services cloud

Vous pouvez adapter :
- Les ports exposés
- Les identifiants de base de données
- La stratégie de versioning d'API
- Les métriques de monitoring spécifiques