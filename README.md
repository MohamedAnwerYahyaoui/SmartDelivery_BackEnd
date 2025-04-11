# SmartDelivery_BackEnd 🚚

## Aperçu 📋

`SmartDelivery_BackEnd` est une application **Spring Boot** conçue pour gérer les opérations de livraison. Le module `Commande` se concentre sur la gestion des commandes au sein du système, offrant des fonctionnalités pour créer, mettre à jour, supprimer et récupérer des commandes, ainsi que pour calculer des statistiques et des totaux à des fins de reporting.

Ce projet fait partie d'un système plus large de gestion de livraisons et est construit avec **Spring Boot**, **Spring Data JPA** et une base de données relationnelle (par exemple, MySQL, H2).

## Module Commande 📦

Le module `Commande` gère les commandes (`Commande` entities) avec les attributs suivants :
- 🆔 `idCommande` : Identifiant unique de la commande (généré automatiquement).
- 💰 `mantantTotal` : Montant total de la commande (float).
- 📅 `dateLiv` : Date de livraison de la commande (`Date`).
- 📊 `status` : Statut de la commande (`Livrée` ou `nonLivrée`).

### Fonctionnalités ✨
- ➕ Créer, ✏️ mettre à jour et 🗑️ supprimer des commandes.
- 📜 Récupérer toutes les commandes ou filtrer par statut.
- 🧮 Calculer le montant total des commandes, avec un filtre optionnel par statut.
- 📈 Générer des statistiques, incluant le nombre de commandes par statut et le montant moyen des commandes.

## Points de terminaison de l'API 🌐

Le module `Commande` expose les points de terminaison REST suivants sous le chemin de base `/commande` :

| Méthode | Point de terminaison       | Description                                      | Corps de la requête/Paramètres de requête     | Exemple de réponse                                                               |
|---------|----------------------------|--------------------------------------------------|-----------------------------------------------|----------------------------------------------------------------------------------|
| GET     | `/commande/list`           | 📜 Récupérer toutes les commandes.              | Aucun                                         | `[{"idCommande": 1, "mantantTotal": 100.0, "dateLiv": "2025-04-11T00:00:00.000+00:00", "status": "Livrée"}]` |
| POST    | `/commande/ajouter`        | ➕ Créer une nouvelle commande.                 | `{"mantantTotal": 100.0, "dateLiv": "2025-04-11T00:00:00.000+00:00", "status": "Livrée"}` | `{"idCommande": 1, "mantantTotal": 100.0, "dateLiv": "2025-04-11T00:00:00.000+00:00", "status": "Livrée"}` |
| PUT     | `/commande/{id}`           | ✏️ Mettre à jour une commande existante par ID. | Chemin : `id`, Corps : `{"mantantTotal": 150.0, "dateLiv": "2025-04-12T00:00:00.000+00:00", "status": "nonLivrée"}` | `{"idCommande": 1, "mantantTotal": 150.0, "dateLiv": "2025-04-12T00:00:00.000+00:00", "status": "nonLivrée"}` |
| DELETE  | `/commande/{id}`           | 🗑️ Supprimer une commande par ID.              | Chemin : `id`                                 | `"commande supprimé"` ou `"commande non supprimé"`                              |
| GET     | `/commande/total-amount`   | 🧮 Calculer le montant total des commandes.     | Requête : `status` (optionnel, ex. `Livrée`)  | `250.0`                                                                         |
| GET     | `/commande/status`         | 📜 Récupérer les commandes par statut.          | Requête : `status` (optionnel, ex. `Livrée`)  | `[{"idCommande": 1, "mantantTotal": 100.0, "dateLiv": "2025-04-11T00:00:00.000+00:00", "status": "Livrée"}]` |
| GET     | `/commande/statistics`     | 📈 Obtenir des statistiques (nombre par statut, montant moyen). | Aucun                                         | `{"countByStatus": {"Livrée": 1, "nonLivrée": 1}, "averageAmount": 150.0}`     |

## Prérequis 🛠️

- ☕ **Java** : JDK 17 ou supérieur
- 📦 **Maven** : Pour la gestion des dépendances et la construction du projet
- 🗄️ **Base de données** : MySQL (ou une autre base de données relationnelle ; configurez dans `application.properties`)
- 🌐 **Git** : Pour cloner le dépôt
- 📬 **Postman** : Pour tester les points de terminaison de l'API
