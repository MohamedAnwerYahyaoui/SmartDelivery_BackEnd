package tn.esprit.Restaurant.OpenFeign;

import java.util.Date;

public class Commande {

    private Long idCommande;
    private float mantantTotal;
    private Date dateLiv;

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

    public Commande(Long idCommande, float mantantTotal, Date dateLiv) {
        this.idCommande = idCommande;
        this.mantantTotal = mantantTotal;
        this.dateLiv = dateLiv;
    }
}
