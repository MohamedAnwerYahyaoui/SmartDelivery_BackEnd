# Eureka Server

Service de découverte centralisé pour l'architecture microservices basé sur Spring Cloud Netflix Eureka.

## 🌟 Fonctionnalités
- Registre central des microservices
- Découverte automatique des instances
- Monitoring des services enregistrés
- Répartition de charge côté client
- Haute disponibilité (cluster possible)

## 🛠 Stack Technique
| Composant          | Version       |
|--------------------|---------------|
| Spring Boot        | 3.2.x         |
| Spring Cloud       | 2023.0.x      |
| Netflix Eureka     | 4.1.x         |
| Java               | 17+           |

server:
  port: 8761

eureka:
  
  client:
    register-with-eureka: false
    fetch-registry: false
    service-url:
      defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/
application-peer1.yml (pour cluster) :


🌐 Dashboard Eureka
Accédez à l'interface web :
http://localhost:8761

Eureka Dashboard

🐳 Configuration Docker
Dockerfile :

dockerfile
FROM openjdk:17
EXPOSE 8076
ADD target/eurekaServer-0.0.1-SNAPSHOT.jar eureka.jar
ENTRYPOINT ["java", "-jar","eureka.jar"]


services:
  eureka-server:
    
server.port=8076
eureka.client.register-with-eureka=false
eureka.client.fetch-registry=false
📦 Dépendances Clés
pom.xml :

xml
Copy
<dependencies>
    <!-- Eureka Server -->
    <dependency>
        <groupId>org.springframework.cloud</groupId>
        <artifactId>spring-cloud-starter-netflix-eureka-server</artifactId>
    </dependency>
    
    <!-- Actuator -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
    
    <!-- Security (optionnel) -->
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-security</artifactId>
    </dependency>
</dependencies>
Run HTML

📄 License
Apache License 2.0



Ce README contient toutes les informations essentielles pour :
1. Démarrer le serveur Eureka
2. Le configurer en mode standalone ou cluster
3. Le déployer avec Docker
4. Surveiller son fonctionnement


Personnalisations possibles :
- Ajouter des configurations spécifiques à votre infrastructure
- Intégrer avec d'autres outils de monitoring
- Configurer la persistance des données de registre