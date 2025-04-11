# API Gateway

Gateway centralisée pour l'architecture microservices basée sur Spring Cloud Gateway avec fonctionnalités avancées de routage et de gestion des requêtes.

## 🌟 Fonctionnalités Clés
- Routage dynamique vers les microservices
- Load balancing côté serveur
- Gestion centralisée du CORS
- Rate limiting
- Rewrite Path

## 🛠 Stack Technique
| Composant               | Version          |
|-------------------------|------------------|
| Spring Boot             | 3.2.x            |
| Spring Cloud Gateway    | 2023.0.x         |
| Spring Cloud Netflix    | 4.1.x            |
|                         |                  |
| Docker                  | 20.10+           |

## 🚀 Démarrage Rapide

### 1. En mode développement
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev

🐳 Configuration Docker
FROM openjdk:17
EXPOSE 8066
ADD target/gateway-0.0.1-SNAPSHOT.jar gateway.jar
ENTRYPOINT ["java", "-jar","gateway.jar"]

🔌 Intégrations
Avec Eureka
#eureka registration
eureka.client.service-url.defaultZone=http://localhost:8076/eureka
eureka.client.register-with-eureka=true
Avec Config Server
spring.cloud.config.enabled=true
management.endpoints.web.exposure.include=refresh,health,info
spring.config.import=optional:configserver:http://localhost:8888/
📦 Dépendances Clés
pom.xml :

xml
Copy
<dependencies>
    <!-- Spring Cloud Gateway -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-gateway</artifactId>
    </dependency>
    
    <!-- Service Discovery -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    
    <!-- Circuit Breaker -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-circuitbreaker-reactor-resilience4j</artifactId>
    </dependency>
    
    <!-- Actuator -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
</dependencies>
Run HTML
📄 License
Apache License 2.0



Ce README contient :
1. Toutes les configurations essentielles
2. Les intégrations avec les autres services
3. La configuration Docker optimisée
4. Des exemples de filtres personnalisés


Personnalisations possibles :
- Ajouter des configurations spécifiques de sécurité
- Intégrer des fournisseurs de rate limiting spécifiques
- Ajouter des métriques custom