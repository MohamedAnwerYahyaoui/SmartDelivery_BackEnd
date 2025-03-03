package tn.esprit.Restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class repas {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String desc;
    private float prix;

    public repas() {
    }

    public repas(String nom, String desc, float prix) {
        this.nom = nom;
        this.desc = desc;
        this.prix = prix;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }
}
