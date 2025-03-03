package tn.esprit.Restaurant.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity

public class Restaurant {
    @Id
    @GeneratedValue
    private Long idRestaurant;
    private float mantantTotale;
    private Boolean Status;


    public Restaurant() {
    }

    public Restaurant(float mantantTotale, Boolean status) {
        this.mantantTotale = mantantTotale;
        Status = status;
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
}
