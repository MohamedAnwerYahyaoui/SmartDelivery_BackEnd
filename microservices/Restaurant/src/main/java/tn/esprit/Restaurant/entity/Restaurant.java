package tn.esprit.Restaurant.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "restaurant2")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRestaurant;
    private float mantantTotale;
    private Boolean Status;
    private String nomresto;


    public Restaurant() {
    }

    public Restaurant(float mantantTotale, Boolean status, String nomresto) {
        this.mantantTotale = mantantTotale;
        this.Status = status;
        this.nomresto=nomresto;
    }

    public Long getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(Long idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public float getMantantTotale() {
        return mantantTotale;
    }

    public void setMantantTotale(float mantantTotale) {
        this.mantantTotale = mantantTotale;
    }

    public Boolean getStatus() {
        return Status;
    }

    public void setStatus(Boolean status) {
        Status = status;
    }

    public String getNomresto() {
        return nomresto;
    }

    public void setNomresto(String nomresto) {
        this.nomresto = nomresto;
    }
}
