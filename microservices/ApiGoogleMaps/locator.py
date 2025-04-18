import folium
import webbrowser
import os
from geopy.geocoders import Nominatim
from geopy.exc import GeocoderTimedOut, GeocoderUnavailable

def trouver_coordonnees(nom_lieu):
    try:
        geolocator = Nominatim(user_agent="ApiGoogleMaps")

        if "restaurant" not in nom_lieu.lower():
            terme_recherche = f"restaurant {nom_lieu}"
        else:
            terme_recherche = nom_lieu

        location = geolocator.geocode(terme_recherche, timeout=10)

        if location:
            return (location.latitude, location.longitude, location.address)
        else:
            location = geolocator.geocode(nom_lieu, timeout=10)
            if location:
                return (location.latitude, location.longitude, location.address)
            else:
                return (None, None, None)
    except (GeocoderTimedOut, GeocoderUnavailable) as e:
        print(f"Erreur de géocodage: {e}")
        return (None, None, None)

def afficher_localisation(latitude, longitude, nom_lieu, adresse=None, zoom=15):
    carte = folium.Map(location=[latitude, longitude], zoom_start=zoom)

    popup_content = f"<b>{nom_lieu}</b>"
    if adresse:
        popup_content += f"<br>{adresse}"

    folium.Marker(
        location=[latitude, longitude],
        popup=folium.Popup(popup_content, max_width=300),
        tooltip=nom_lieu,
        icon=folium.Icon(color='red', icon='cutlery', prefix='fa')
    ).add_to(carte)

    folium.Circle(
        location=[latitude, longitude],
        radius=100,
        color='blue',
        fill=True,
        fill_opacity=0.2
    ).add_to(carte)

    fichier = 'carte_restaurant.html'
    carte.save(fichier)
    chemin_fichier = 'file://' + os.path.abspath(fichier)
    print(f"Carte générée : {chemin_fichier}")
    webbrowser.open(chemin_fichier)
