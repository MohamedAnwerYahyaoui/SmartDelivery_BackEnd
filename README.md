🚀 SmartDelivery – Module Notification

Java Spring Boot | License

Microservice complet pour la gestion et la diffusion des notifications dans l’écosystème SmartDelivery, offrant des fonctionnalités avancées de suivi, de reporting et d’intégration en temps réel.

✨ Fonctionnalités Clés

Fonctionnalité                                   Description

*Gestion des Notifications	                       => CRUD complet (création, lecture, mise à jour, suppression) avec validation

*Envoi Groupé Personnalisé	                       => Envoi de plusieurs notifications via un template dynamique (placeholders)

*Historique par Client	Liste                      => chronologique des notifications pour un client, triée par date décroissante

*Statistiques & Analytics	                         => Endpoint de statistiques globales (total, lues, non lues)

*Diffusion en Temps Réel	                         => Intégration WebSocket/STOMP pour push instantané (si le client est connecté)

*Marquage Lu / Non Lu	                              => Possibilité de marquer une notification comme lue ou non lue

🔍 Aperçu des Endpoints API

Gestion des Notifications

GET /notification

Liste complète des notifications

GET /notification/{id}

Récupération des détails d’une notification

POST /notification/ajouter

Ajout d’une nouvelle notification

PUT /notification/{id}

Mise à jour d’une notification

DELETE /notification/{id}

Suppression d’une notification

✨ Fonctionnalités Avancées

POST /notification/group

Envoi groupé de notifications personnalisées à l’aide d’un template

GET /notification/history/{nomClient}

Historique des notifications d’un client, trié par date décroissante

GET /notification/stats

Statistiques globales (nombre total, lues, non lues)

POST /notification/{id}/markAsRead

Marquer une notification comme lue

POST /notification/{id}/markAsUnread

Marquer une notification comme non lue

Diffusion en Temps Réel

WebSocket :

Connexion à l’endpoint ws://{host}:{port}/ws-notifications

/app/sendNotification : envoi de messages STOMP au serveur

/topic/notifications : réception en temps réel des notifications

🛠 Configuration Technique

Prérequis

Java 17+

Maven 3.8+

MySQL 8.0 (ou autre base SQL)

Accès SMTP si vous étendez le microservice pour envoyer des emails

Installation

Cloner le dépôt :

git clone https://github.com/MohamedAnwerYahyaoui/SmartDelivery_BackEnd.git

cd SmartDelivery_BackEnd



