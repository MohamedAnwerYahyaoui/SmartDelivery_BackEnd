package tn.esprit.annonce.Entity;

import java.util.Map;

public class IndividualNotification {

    // Le nom du client pour cette notification personnalisée
    private String nomClient;
    // Un map de données pour remplacer les placeholders dans le template
    private Map<String, String> data;

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }
}