package tn.esprit.annonce.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Notification {
    @Id
    @GeneratedValue
    private Long idNotification;
    private String NomClient;
    private String Contenu;
    private Date date;

    public Notification() {
    }

    public Notification(String nomClient, String contenu, Date date) {
        this.NomClient = nomClient;
        this.Contenu = contenu;
        this.date = date;
    }

    public Long getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Long idNotification) {
        this.idNotification = idNotification;
    }

    public String getNomClient() {
        return NomClient;
    }

    public void setNomClient(String nomClient) {
        NomClient = nomClient;
    }

    public String getContenu() {
        return Contenu;
    }

    public void setContenu(String contenu) {
        Contenu = contenu;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
