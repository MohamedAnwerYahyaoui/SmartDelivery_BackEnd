package tn.esprit.Commande.OpenFeign;

public class ClientRequest {


    private String nom;
    private String adresse;
    private String mail;


    public ClientRequest() {
    }


    public ClientRequest(String nom, String adresse, String mail) {
        this.nom = nom;
        this.adresse = adresse;
        this.mail = mail;
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

    public String getmail() {
        return mail;
    }

    public void setmail(String mail) {
        this.mail = mail;
    }
}
