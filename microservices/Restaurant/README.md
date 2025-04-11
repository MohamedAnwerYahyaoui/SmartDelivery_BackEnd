# Microservice Restaurant

Microservice de gestion des restaurants avec intégration Spring Cloud et conteneurisation Docker.

## 📌 Fonctionnalités
- CRUD complet pour les restaurants
- Gestion des menus associés
- Intégration avec API Gateway
- Service Discovery via Eureka
- Configuration centralisée

## 🛠 Stack Technique
| Composant          | Technologie           |
|--------------------|-----------------------|
| Framework          | Spring Boot 3.2       |
| Base de données    | Mysql                 |
| Service Discovery | Spring Cloud Eureka   |
| API Gateway        | Spring Cloud Gateway  |
| Config             | Spring Cloud Config   |
| Container          | Docker + Compose      |

## 🚀 Démarrage


🔧 Configuration
application.yml:


#config
spring.cloud.config.enabled=true
management.endpoints.web.exposure.include=refresh,health,info
spring.config.import=optional:configserver:http://localhost:8888/

🐳 Docker Configuration
Dockerfile:
FROM openjdk:17
EXPOSE 8082
ADD target/Restaurant-0.0.1-SNAPSHOT.jar restaurant.jar
ENTRYPOINT ["java", "-jar","restaurant.jar"]

services:
  

#config
spring.cloud.config.enabled=true
management.endpoints.web.exposure.include=refresh,health,info
spring.config.import=optional:configserver:http://localhost:8888/
📦 Dépendances Principales
xml
Copy
<!-- Spring Boot -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Spring Data JPA -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>

<!-- PostgreSQL -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>

<!-- Eureka Client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<!-- Validation -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>




📄 License
Apache License 2.0



Points clés inclus :
1. Configuration Mysql conteneurisée
2. Healthcheck Docker intégré
3. Exemples complets d'endpoints API
4. Intégration avec les autres services Spring Cloud


Personnalisations possibles :
- Ajouter la configuration Swagger/OpenAPI
- Adapter les paramètres de connection pool
- Préciser les métriques custom