package tn.esprit.Commande.OpenFeign;

public class LivreurRequest {

    private Long idLivreur;
    private String NomLiv;
    private String adresse;
    private String email;


    public LivreurRequest(String nomLiv, String adresse, String email) {
        NomLiv = nomLiv;
        this.adresse = adresse;
        this.email = email;
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

    public Long getIdLivreur() {
        return idLivreur;
    }

    public void setIdLivreur(Long idLivreur) {
        this.idLivreur = idLivreur;
    }
}
