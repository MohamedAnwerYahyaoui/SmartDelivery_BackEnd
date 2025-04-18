package tn.esprit.livreur.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Livreur {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idLivreur;
    private String NomLiv;
    private String adresse;
    private String email;




    public Livreur(){}

    public Livreur(String nomLiv, String adresse, String email) {
        NomLiv = nomLiv;
        this.adresse = adresse;
        this.email = email;
    }

    public Long getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(Long idLivreur) {
        this.idLivreur = idLivreur;
    }

    public String getNomLiv() {
        return NomLiv;
    }

    public void setNomLiv(String nomLiv) {
        NomLiv = nomLiv;
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
