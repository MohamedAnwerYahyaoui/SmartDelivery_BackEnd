package tn.esprit.Commande.Service;

import feign.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.Commande.Entity.Commande;
import tn.esprit.Commande.OpenFeign.ClientClient;
import tn.esprit.Commande.OpenFeign.ClientRequest;
import tn.esprit.Commande.OpenFeign.EmailClient;
import tn.esprit.Commande.OpenFeign.EmailRequest;
import tn.esprit.Commande.Repository.CommandeRepo;

import java.util.List;

@Service
public class CommandeService {
private final ClientClient client;
    private CommandeRepo cr;

    @Autowired
    private EmailClient emailClient;

    public CommandeService(CommandeRepo cr,EmailClient emailClient,ClientClient client){
        this.cr=cr;
        this.emailClient=emailClient;
        this.client=client;
    }



    public Commande ajouterCommande(Commande commande) {
        return cr.save(commande);
    }


    public List<Commande> findAll() {
        return cr.findAll();
    }


    public Commande updateCommande(long id, Commande newCommande) {
        if (cr.findById(id).isPresent()) {
            Commande commande = cr.findById(id).get();
            commande.setStatus(newCommande.getStatus());
            commande.setDateLiv(newCommande.getDateLiv());
            commande.setStatus(newCommande.getStatus());
            return cr.save(commande);
        } else
            return null;
    }


    public String deleteCommande(long id) {
        if (cr.findById(id).isPresent()) {
            cr.deleteById(id);
            return "commande supprimé";
        } else
            return "commande non supprimé";
    }






    public void confirmerCommande(Long idCommande, Long clientId) {
        Commande commande = cr.findById(idCommande)
                .orElseThrow(() -> new RuntimeException("Commande not found"));

        System.out.println("Recherche du client avec l'ID: " + clientId);

        // Utilisation de la méthode findById pour récupérer le client par ID
        ClientRequest cl = client.findById(clientId).getBody(); // Le client est retourné dans le body de la réponse

        System.out.println("Client reçu: " + cl);

        if (cl == null) {
            throw new RuntimeException("Client not found with ID: " + clientId);
        }

        try {
            // Envoi de l'email de confirmation
            EmailRequest e = new EmailRequest(cl.getAdresse(), "Confirmation de votre commande #" + commande.getIdCommande(),
                    "Votre commande est en cours de préparation.");
            EmailRequest email = new EmailRequest(
                    cl.getEmail(),
                    "Confirmation de votre commande #" + commande.getIdCommande(),
                    "Votre commande est en cours de préparation."
            );

            // Envoi des emails
            emailClient.sendEmail(e);
            emailClient.sendEmail(email);
            System.out.println("Email envoyé avec succès à " + cl.getEmail());
        } catch (Exception e) {
            System.out.println("Erreur lors de l'envoi de l'email: " + e.getMessage());
        }
    }


//    public void confirmerCommande(Long idCommande,String nom) {
//        Commande commande = cr.findById(idCommande).get();
//        ClientRequest cl =client.findbynom(nom);
//
//
//        EmailRequest email = new EmailRequest(
//                cl.getEmail(),
//                "Confirmation de votre commande",
//                "Votre commande #" + commande.getIdCommande() + " est en cours de préparation."
//        );
//
//        emailClient.sendEmail(email);
//    }
//
//
//
//


}

















