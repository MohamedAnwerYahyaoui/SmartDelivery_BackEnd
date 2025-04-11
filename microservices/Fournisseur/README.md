# Microservice Fournisseur

Microservice CRUD pour la gestion des fournisseurs dans une architecture Spring Cloud.

## 📋 Prérequis

- Java 17+
- Docker 20+
- Docker Compose 2.2+
- Maven 3.8+

## 🚀 Démarrage rapide

### 1. Avec Maven

```bash
mvn spring-boot:run
2. Avec Docker
bash
Copy
docker build -t fournisseur-service .
docker run -p 8080:8080 fournisseur-service
3. Avec Docker Compose
bash
Copy
docker-compose up --build
🔧 Configuration
Le service utilise Spring Cloud Config. Les paramètres par défaut :

yaml
Copy
server:
  port: 8082

eureka:
  client:
    serviceUrl:
      defaultZone: http://localhost:8761/eureka

spring:
  application:
    name: fournisseur-service
  datasource:
    url: jdbc:postgresql://db:5432/fournisseur_db
    username: postgres
    password: password
🌐 Endpoints
Méthode	Endpoint	Description
GET	/api/fournisseurs	Liste tous les fournisseurs
GET	/api/fournisseurs/{id}	Obtenir un fournisseur
POST	/api/fournisseurs	Créer un fournisseur
PUT	/api/fournisseurs/{id}	Mettre à jour un fournisseur
DELETE	/api/fournisseurs/{id}	Supprimer un fournisseur
🐳 Docker Compose
Le fichier docker-compose.yml inclut :

yaml
Copy
version: '3.8'

services:
  fournisseur-service:
    image: fournisseur-service
    build: .
    ports:
      - "8082:8082"
    depends_on:
      - config-server
      - eureka-server
    environment:
      - SPRING_PROFILES_ACTIVE=docker
📦 Dépendances principales
xml
Copy
<dependencies>
    <!-- Spring Boot Web -->
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
    
    <!-- PostgreSQL -->
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <scope>runtime</scope>
    </dependency>
</dependencies>
Run HTML
📌 Notes
Le service s'enregistre automatiquement sur Eureka

La configuration est récupérée depuis le Config Server

Les requêtes passent par le Gateway

📄 License
MIT

Copy

Ce fichier README.md contient toutes les informations essentielles pour votre microservice fournisseur et est prêt à être utilisé dans votre projet. Vous pouvez le personnaliser selon vos besoins spécifiques.