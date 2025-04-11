package tn.esprit.promotion.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.util.Date;

@Entity
public class Promotions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
    private String Description;
    private LocalDateTime date;
    private String offre;
    private int prix;

    public Promotions() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }



    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getOffre() {
        return offre;
    }

    public void setOffre(String offre) {
        this.offre = offre;
    }

    public int getPrix() {
        return prix;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public Promotions(String description, LocalDateTime date, String offre, int prix) {
        Description = description;
        this.date = date;
        this.offre = offre;
        this.prix = prix;
    }


    public LocalDateTime  getDate() {

        return date;
    }
}
