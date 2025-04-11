# Microservice Client

Microservice CRUD pour la gestion des clients dans une architecture Spring Cloud.

## 📋 Prérequis

- Java 17+
- Docker 20+
- Docker Compose 2.2+
- Maven 3.8+

## � Architecture
[Client] → [API Gateway] → [Eureka] → [Config Server]
↑
[Autres Microservices]

Copy

## 🚀 Démarrage rapide

### 1. Avec Maven
```bash
mvn clean install
mvn spring-boot:run -Dspring-boot.run.profiles=dev
2. Avec Docker
bash
Copy
docker build -t client-service:1.0.0 .
docker run -p 8081:8081 --network=microservices-net client-service
3. Avec Docker Compose (intégré)
bash
Copy
docker-compose -f docker-compose.yml up --build
🔧 Configuration
application.yml:

yaml
Copy
server:
  port: 8081

spring:
  application:
    name: client-service
  cloud:
    config:
      uri: http://config-server:8888
  datasource:
    url: jdbc:postgresql://client-db:5432/clientdb
    username: admin
    password: securepass

eureka:
  client:
    serviceUrl:
      defaultZone: http://eureka-server:8761/eureka
    healthcheck:
      enabled: true
🌐 Endpoints API
Méthode	Endpoint	Description
GET	/clients	Liste tous les clients
POST	/clients	Crée un nouveau client
GET	/clients/{id}	Récupère un client par ID
PUT	/clients/{id}	Met à jour un client
DELETE	/clients/{id}	Supprime un client
GET	/clients/search	Recherche filtrée (nom, email)
🐳 Docker Configuration
Dockerfile:

dockerfile
Copy
FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
docker-compose.yml (extrait client):

yaml
Copy
services:
  client-service:
    image: client-service:1.0.0
    container_name: client-service
    ports:
      - "8081:8081"
    environment:
      - SPRING_PROFILES_ACTIVE=docker
    depends_on:
      - config-server
      - eureka-server
      - client-db
    networks:
      - microservices-net

  client-db:
    image: postgres:13
    environment:
      POSTGRES_DB: clientdb
      POSTGRES_USER: admin
      POSTGRES_PASSWORD: securepass
    volumes:
      - client-data:/var/lib/postgresql/data

volumes:
  client-data:
📦 Dépendances Clés (pom.xml)
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

<!-- Eureka Client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
</dependency>

<!-- Config Client -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-config</artifactId>
</dependency>

<!-- Lombok -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>

<!-- PostgreSQL -->
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <scope>runtime</scope>
</dependency>
Run HTML
🔍 Monitoring
Le service expose des endpoints Actuator :

/actuator/health - Santé du service

/actuator/info - Informations de version

/actuator/metrics - Métriques JVM

🛠️ Bonnes Pratiques
Versioning API : Utilisez /api/v1/clients pour la version 1

Circuit Breaker : Ajoutez Resilience4j pour la tolérance aux pannes

Logging : Configurez ELK ou Sleuth/Zipkin pour le tracing

📄 License
Apache 2.0

Copy

Ce README contient :
1. Toutes les informations techniques nécessaires
2. La configuration Docker complète
3. Les endpoints API documentés
4. L'intégration avec les autres services Spring Cloud
5. Des bonnes pratiques recommandées

Vous pouvez adapter les ports, noms de base de données et autres paramètres selon votre configuration spécifique.