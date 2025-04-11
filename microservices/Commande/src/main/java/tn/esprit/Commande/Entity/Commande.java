package tn.esprit.Commande.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Commande {


    @Id
    @GeneratedValue
    private Long idCommande;
    private float mantantTotal;
    private Date dateLiv;
    private Status status;


    public Commande() {
    }

    public Commande(float mantantTotal, Date dateLiv, Status status) {
        this.mantantTotal = mantantTotal;
        this.dateLiv = dateLiv;
        this.status = status;
    }

    public Long getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(Long idCommande) {
        this.idCommande = idCommande;
    }

    public float getMantantTotal() {
        return mantantTotal;
    }

    public void setMantantTotal(float mantantTotal) {
        this.mantantTotal = mantantTotal;
    }

    public Date getDateLiv() {
        return dateLiv;
    }

    public void setDateLiv(Date dateLiv) {
        this.dateLiv = dateLiv;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
