package tn.esprit.Commande.OpenFeign;

public class ClientRequest {


    private String nom;
    private String adresse;
    private String email;


    public ClientRequest() {
    }


    public ClientRequest(String nom, String adresse, String email) {
        this.nom = nom;
        this.adresse = adresse;
        this.email = email;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
