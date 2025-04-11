# 🚀 SmartDelivery - Module Fournisseur

![Java](https://img.shields.io/badge/Java-17%2B-blue)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1-green)
![License](https://img.shields.io/badge/License-MIT-orange)

Microservice complet pour la gestion des fournisseurs dans l'écosystème SmartDelivery, offrant des fonctionnalités avancées de gestion, reporting et intégration.

## ✨ Fonctionnalités Clés

| Fonctionnalité               | Description                                                                 |
|------------------------------|-----------------------------------------------------------------------------|
| **Gestion des Fournisseurs** | CRUD complet avec validation des données                                    |
| **Génération de Documents**  | Export PDF et Excel professionnels                                          |
| **QR Code Digital**          | Génération instantanée de codes QR contenant les détails du fournisseur     |
| **Notifications Email**      | Système d'envoi d'emails automatisé                                        |
| **Tableau de Bord**          | Statistiques et analytics en temps réel                                     |

## 🔍 Aperçu des Endpoints API

### Gestion des Fournisseurs
- `GET /fournisseur/list` - Liste complète des fournisseurs
- `POST /fournisseur/ajouter` - Ajout d'un nouveau fournisseur
- `PUT /fournisseur/{id}` - Mise à jour des informations
- `DELETE /fournisseur/{id}` - Suppression d'un fournisseur

### Fonctionnalités Avancées
- `GET /fournisseur/{id}/pdf` - Télécharger la fiche fournisseur en PDF
- `GET /fournisseur/{id}/excel` - Exporter les données en Excel
- `GET /fournisseur/statistiques` - Obtenir les statistiques globales
- `GET /fournisseur/{id}/qrcode` - Générer un QR Code d'identification

## 🛠 Configuration Technique

### Prérequis
- Java 17+
- Maven 3.8+
- MySQL 8.0 ou PostgreSQL 13+
- Compte SMTP pour les emails

### Installation
1. Cloner le dépôt :
```bash
git clone https://github.com/MohamedAnwerYahyaoui/SmartDelivery_BackEnd.git
cd SmartDelivery_BackEnd
