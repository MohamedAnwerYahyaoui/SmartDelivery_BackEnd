from fastapi import FastAPI, Query
import py_eureka_client.eureka_client as eureka_client
from locator import trouver_coordonnees, afficher_localisation

app = FastAPI()

@app.on_event("startup")
async def startup_event():
    await eureka_client.init_async(
        eureka_server="http://localhost:8076/eureka/",
        app_name="localisation_map",
        instance_port=8002
    )



@app.get("/ping")
def ping():
    return {"message": "Hello from restaurant-locator!"}

@app.get("/localiser")
def localiser(nom: str = Query(..., description="Nom du restaurant à localiser")):
    latitude, longitude, adresse = trouver_coordonnees(nom)

    if latitude and longitude:
        afficher_localisation(latitude, longitude, nom, adresse)
        return {
            "nom": nom,
            "adresse": adresse,
            "latitude": latitude,
            "longitude": longitude,
            "carte": "carte_restaurant.html"
        }
    else:
        return {"error": "Restaurant non trouvé. Essayez un nom plus précis."}
