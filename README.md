# Microservice Commande

## Description

Le microservice **Commande** fait partie d'une architecture microservices et permet de gérer les commandes dans l'application. Il utilise plusieurs technologies pour assurer son bon fonctionnement et son intégration avec d'autres services.

## Technologies Utilisées

- **Docker & Docker Compose** : Utilisé pour containeriser le microservice et faciliter son déploiement avec une architecture multi-containers.
- **OpenFeign** : Utilisé pour la communication entre les microservices, notamment avec le service client et le service de mailing.
- **Eureka** : Utilisé comme serveur de découverte pour gérer la communication entre les différents microservices.
- **API Gateway** : Sert de point d'entrée unique pour les microservices.
- **Config Server** : Gère les configurations centralisées pour tous les microservices.
- **MySQL** : Base de données utilisée pour stocker les informations relatives aux commandes.

## Fonctionnalités

- **Création de commande** : Permet de créer une commande pour un client.
- **Confirmer la commande** : Envoie une confirmation de commande à un client par email.
- **Lister les commandes** : Affiche toutes les commandes existantes.
- **Mettre à jour une commande** : Modifie les détails d'une commande existante.
- **Supprimer une commande** : Supprime une commande du système.

## Endpoints

- `POST /commande/ajouter` : Crée une nouvelle commande.
- `GET /commande/list` : Retourne la liste de toutes les commandes.
- `GET /commande/{id}` : Trouve une commande par son ID.
- `PUT /commande/{id}` : Met à jour une commande existante.
- `DELETE /commande/{id}` : Supprime une commande.
- `POST /commande/confirm/{idCommande}/{nomClient}` : Confirme une commande et envoie un email de confirmation.

## Installation

1. Clonez ce dépôt :


Utilisez Docker Compose pour démarrer tous les services nécessaires (MySQL, Eureka, etc.) :

bash

Modifier
docker-compose up --build
Accédez à l'application via http://localhost:8080.

Configuration
Assurez-vous que votre serveur Eureka est en cours d'exécution avant de démarrer ce microservice.

La configuration des microservices est centralisée via Config Server.

Prérequis
Docker et Docker Compose

Java 17 

MySQL (conteneurisé via Docker)

Spring Boot et Spring Cloud

OpenFeign, Eureka, API Gateway

Auteurs
Mannai Atef : Développeur principal

Licence
Ce projet est sous la licence MIT. Consultez le fichier LICENSE pour plus d'informations.
