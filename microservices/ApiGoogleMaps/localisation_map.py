import folium
import webbrowser
import os
from geopy.geocoders import Nominatim
from geopy.exc import GeocoderTimedOut, GeocoderUnavailable

def trouver_coordonnees(nom_lieu):
    """
    Convertit un nom de lieu en coordonnées géographiques (latitude, longitude).
    
    Args:
        nom_lieu (str): Nom du lieu à rechercher
        
    Returns:
        tuple: (latitude, longitude, adresse_complete) ou (None, None, None) si non trouvé
    """
    try:
        # Initialiser le géocodeur avec un user-agent personnalisé
        geolocator = Nominatim(user_agent="restaurant_locator")
        
        # Ajouter "restaurant" au nom du lieu pour améliorer la recherche
        if "restaurant" not in nom_lieu.lower():
            terme_recherche = f"restaurant {nom_lieu}"
        else:
            terme_recherche = nom_lieu
            
        # Effectuer la recherche
        location = geolocator.geocode(terme_recherche, timeout=10)
        
        if location:
            return (location.latitude, location.longitude, location.address)
        else:
            # Essayer sans le mot "restaurant" si la première recherche échoue
            location = geolocator.geocode(nom_lieu, timeout=10)
            if location:
                return (location.latitude, location.longitude, location.address)
            else:
                print(f"Impossible de trouver l'emplacement de '{nom_lieu}'")
                return (None, None, None)
                
    except (GeocoderTimedOut, GeocoderUnavailable) as e:
        print(f"Erreur de géocodage: {e}")
        return (None, None, None)

def afficher_localisation(latitude, longitude, nom_lieu, adresse=None, zoom=15):
    """
    Crée une carte avec un marqueur à l'emplacement spécifié et l'affiche dans le navigateur.
    
    Args:
        latitude (float): Latitude de l'emplacement
        longitude (float): Longitude de l'emplacement
        nom_lieu (str): Nom du lieu à afficher dans le popup
        adresse (str): Adresse complète du lieu (optionnelle)
        zoom (int): Niveau de zoom de la carte (1-18)
    """
    # Créer une carte centrée sur les coordonnées spécifiées
    carte = folium.Map(location=[latitude, longitude], zoom_start=zoom)
    
    # Préparer le contenu du popup
    popup_content = f"<b>{nom_lieu}</b>"
    if adresse:
        popup_content += f"<br>{adresse}"
    
    # Ajouter un marqueur à l'emplacement
    folium.Marker(
        location=[latitude, longitude],
        popup=folium.Popup(popup_content, max_width=300),
        tooltip=nom_lieu,
        icon=folium.Icon(color='red', icon='cutlery', prefix='fa')
    ).add_to(carte)
    
    # Ajouter un cercle pour montrer la zone approximative
    folium.Circle(
        location=[latitude, longitude],
        radius=100,  # rayon en mètres
        color='blue',
        fill=True,
        fill_opacity=0.2
    ).add_to(carte)
    
    # Sauvegarder la carte en HTML
    nom_fichier = 'carte_restaurant.html'
    carte.save(nom_fichier)
    
    # Afficher la carte dans le navigateur
    chemin_fichier = 'file://' + os.path.abspath(nom_fichier)
    print(f"Ouverture de la carte pour '{nom_lieu}'")
    print(f"Coordonnées: {latitude}, {longitude}")
    if adresse:
        print(f"Adresse: {adresse}")
    webbrowser.open(chemin_fichier)

def localiser_restaurant():
    """
    Fonction principale qui demande le nom d'un restaurant et affiche sa localisation.
    """
    print("=== LOCALISATEUR DE RESTAURANT ===")
    while True:
        nom_restaurant = input("\nEntrez le nom du restaurant (ou 'q' pour quitter): ")
        
        if nom_restaurant.lower() == 'q':
            print("Au revoir!")
            break
            
        if not nom_restaurant.strip():
            print("Veuillez entrer un nom valide.")
            continue
            
        print(f"Recherche de '{nom_restaurant}'...")
        latitude, longitude, adresse = trouver_coordonnees(nom_restaurant)
        
        if latitude and longitude:
            afficher_localisation(latitude, longitude, nom_restaurant, adresse)
        else:
            print("Essayez d'être plus précis ou d'ajouter la ville/pays.")

# Exécuter le programme si le script est lancé directement
if __name__ == "__main__":
    # Vérifier si les bibliothèques nécessaires sont installées
    try:
        import folium
        import geopy
    except ImportError:
        print("Installation des bibliothèques nécessaires...")
        print("Exécutez les commandes suivantes dans votre terminal:")
        print("pip install folium geopy")
        exit(1)
        
    localiser_restaurant()

# Exemple de test (décommentez pour tester directement)
# latitude, longitude, adresse = trouver_coordonnees("Le Jules Verne Paris")
# if latitude and longitude:
#     afficher_localisation(latitude, longitude, "Le Jules Verne", adresse)