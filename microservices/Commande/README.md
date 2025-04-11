# Microservice Commande

Microservice de gestion des commandes avec intégration de services externes via OpenFeign.

## 🌟 Fonctionnalités Spéciales
- CRUD complet des commandes
- Intégration avec :
  - Microservice Client (Spring Boot)
  - Service Mailing (Node.js)
- Envoi de liens de confirmation par email


## 🛠 Stack Technique
| Composant          | Technologie           |
|--------------------|-----------------------|
| Framework          | Spring Boot 3.2       |
| Client HTTP        | OpenFeign             |
| Base de données    | MysqL              |
| Communication      | REST API              |
|         |         |
| Container          | Docker + Compose      |

#
🔌 Intégrations
Configuration OpenFeign
pom.xml:

xml
Copy
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
Run HTML
Main class:

java

@EnableFeignClients
@SpringBootApplication
public class CommandeServiceApplication { ... }
Clients Feign
Client Microservice:

java
Copy
@FeignClient(name = "client-service", url = "${feign.client-service.url}")
public interface ClientServiceClient {
    
    @GetMapping("/clients/{id}")
    Client getClient(@PathVariable Long id);
    
    @PostMapping("/clients/commander/{id}")
    void sendNotification(@PathVariable Long id, @RequestBody NotificationRequest request);
}
Service Mailing (Node.js):

java

@FeignClient(name = "mailing-service", url = "${feign.mailing-service.url}")
public interface MailingServiceClient {
    
    @PostMapping("/email/send")
    EmailResponse sendEmail(@RequestBody EmailRequest request);
}
🌐 API Endpoints


📨 Flow de Confirmation
Client passe commande

Service:

Vérifie le client (via client-service)

Crée la commande en DB

Génère un lien de confirmation

Envoie l'email (via mailing-service)

Email contient:

text
Confirmez votre commande: 



<!-- OpenFeign -->
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>





🛡 Gestion des Erreurs
Fallback methods pour les appels Feign






📄 License
MIT License


Points clés :
1. Intégration complète avec OpenFeign
2. Configuration détaillée pour les appels externes
3. Mécanisme de confirmation par email
5. Configuration Docker complète

Personnalisations possibles :
- Ajouter des headers d'authentification pour les appels Feign
- Implémenter des stratégies de retry plus sophistiquées
- Ajouter la traçabilité des appels avec Sleuth/Zipkin