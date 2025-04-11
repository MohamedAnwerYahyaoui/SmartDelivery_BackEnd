package tn.esprit.Fournisseur.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFournisseur;
    private String NomFournisseur;
    private String adresse;
    private int numtel;


    public Fournisseur() {
    }

    public Long getIdFournisseur() {
        return idFournisseur;
    }

    public void setIdFournisseur(Long idFournisseur) {
        this.idFournisseur = idFournisseur;
    }

    public String getNomFournisseur() {
        return NomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        NomFournisseur = nomFournisseur;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getNumtel() {
        return numtel;
    }

    public void setNumtel(int numtel) {
        this.numtel = numtel;
    }

    public Fournisseur(String nomFournisseur, String adresse, int numtel) {
        NomFournisseur = nomFournisseur;
        this.adresse = adresse;
        this.numtel = numtel;
    }
}
