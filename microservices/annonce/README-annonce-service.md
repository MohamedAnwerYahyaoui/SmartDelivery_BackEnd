
# Microservice Annonce (Notification)

Le microservice **Annonce (Notification)** est un service développé avec **Spring Boot** qui permet l'envoi de notifications pour les utilisateurs, comme des emails de confirmation, des alertes, etc. Ce service fait partie d'une architecture microservices intégrée à **Eureka Server**, **Config Server**, et **API Gateway**.

## Architecture

- **Spring Boot** pour le développement du microservice.
- **Eureka Server** pour la découverte des services.
- **Config Server** pour la gestion centralisée des configurations.
- **API Gateway** pour le routage des requêtes.

## Fonctionnalités


- Enregistrement auprès d'Eureka Server pour permettre la découverte du service.
- Configuration centralisée via Config Server.
- Intégration avec un API Gateway pour gérer le routage des requêtes.

## Prérequis

Avant de commencer, assurez-vous que vous avez les éléments suivants installés :

- **JDK 17+** ou version supérieure
- **Docker** et **Docker Compose** pour le déploiement
- **Spring Cloud Eureka Server** pour la découverte des services
- **Spring Cloud Config Server** pour la gestion des configurations
- **API Gateway** pour gérer les requêtes et le routage entre microservices

## Installation puis 



### Démarrer les services

Démarrez les services à l'aide de Docker Compose :

```bash
docker-compose up -d
```

Cela va démarrer le microservice **Annonce**, le **Eureka Server**, le **Config Server**, et le **API Gateway**.

## Test de l'application

Une fois que les services sont en cours d'exécution, vous pouvez tester le service **Annonce** en accédant à :

- **Eureka Server** : [http://localhost:8761](http://localhost:8761)
- **API Gateway** : [http://localhost:8080](http://localhost:8080)


## Gestion des erreurs

Le microservice **Annonce** utilise les codes d'état HTTP pour signaler les erreurs :

- `200 OK` : La notification a été envoyée avec succès.
- `400 Bad Request` : La requête est mal formée (par exemple, des champs manquants).
- `500 Internal Server Error` : Erreur serveur (par exemple, une erreur lors de l'envoi de l'email).

## Contribuer

1. Fork ce projet.
2. Créez une branche pour votre fonctionnalité (`git checkout -b feature-nouvelle-fonctionnalite`).
3. Commitez vos changements (`git commit -am 'Ajout d'une nouvelle fonctionnalité'`).
4. Poussez la branche (`git push origin feature-nouvelle-fonctionnalite`).
5. Ouvrez une demande de fusion (Pull Request).

## License

Ce projet est sous licence **MIT** - voir le fichier [LICENSE](LICENSE) pour plus de détails.
