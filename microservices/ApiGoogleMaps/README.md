# Microservice Localisation Restaurants

Service géospatial permettant de trouver des restaurants à proximité et d'afficher leurs positions sur une maps.

## 🌍 Fonctionnalités
- Recherche de restaurants par rayon géographique
- API RESTful pour les autres microservices

## 🛠 Stack Technique
| Composant          | Technologie           |
|--------------------|-----------------------|
| Langage            | Python 3.10+          |
| Framework          | FastAPI               |
|    |  |
| Géospatial         | GeoJSON, PyGeos       |
|       |     |
| Cache              | Redis                 |

## 🚀 Démarrage Rapide

### 1. Installation
```bash
pip install 



🌐 API Endpoints
Points d'accès principaux
Méthode	Endpoint	Description
GET	/api/restaurants/nearby	Recherche par proximité
POST	/api/restaurants	Ajout d'un nouveau restaurant
GET	/api/restaurants/{id}	Détails d'un restaurant
GET	/api/restaurants/{id}/map	Affiche la position sur une carte
Exemple de requête





📄 License
MIT License



Ce README fournit :
1. Toutes les instructions d'installation et d'exécution
2. La documentation complète de l'API
3. Des exemples de requêtes géospatiales
5. La structure du code et les bonnes pratiques

Personnalisations possibles :
- Ajouter des exemples de requêtes plus complexes
- Intégrer des fournisseurs de cartes spécifiques 
- Ajouter des métriques de performance