# Config Server

Service centralisé de gestion des configurations pour l'écosystème microservices.

## 🌟 Fonctionnalités
- Serveur de configuration centralisée
- Support multi-environnements (dev, staging, prod)
- Versionnement des configurations via Git
- Chiffrement des propriétés sensibles
- Intégration avec Eureka
- Refresh dynamique sans redémarrage (/actuator/refresh)

## 🛠 Stack Technique
| Composant          | Version       |
|--------------------|---------------|
| Spring Boot        | 3.2.x         |
| Spring Cloud Config| 2023.0.x      |
| Git Backend        | (GitHub/GitLab)|
| Java               | 17+           |
| Docker             | 20.10+        |

## 🚀 Démarrage Rapide

🔧 Configuration Principale



eureka:
  #eureka registration
eureka.client.service-url.defaultZone=http://localhost:8076/eureka
eureka.client.register-with-eureka=true


🐳 Configuration Docker
Dockerfile :
FROM openjdk:17
EXPOSE 8888
ADD target/config-server-0.0.1-SNAPSHOT.jar configserver.jar
ENTRYPOINT ["java", "-jar","configserver.jar"]

services:
  config-server:
   
 spring.application.name=config-server
server.port=8888
#eureka registration
eureka.client.service-url.defaultZone=http://localhost:8076/eureka
eureka.client.register-with-eureka=true
#mode local
spring.profiles.active=native
spring.cloud.config.server.native.search-locations=classpath:/config
📦 Dépendances Clés
pom.xml :

xml
Copy
<dependencies>
    <!-- Config Server -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-config-server</artifactId>
    </dependency>
    
    <!-- Actuator -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    
    <!-- Eureka Client -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-client</artifactId>
    </dependency>
    
    <!-- Security (optionnel) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>


📄 License
Apache License 2.0



Ce README contient :
1. Toutes les configurations essentielles
2. La gestion du chiffrement des données sensibles
3. La configuration Docker optimisée
4. Les bonnes pratiques pour la production
5. Les mécanismes de refresh de configuration

Personnalisations possibles :
- Ajouter des backends alternatifs (Vault, JDBC)
- Configurer des stratégies de backup
- Intégrer avec des outils de monitoring avancés