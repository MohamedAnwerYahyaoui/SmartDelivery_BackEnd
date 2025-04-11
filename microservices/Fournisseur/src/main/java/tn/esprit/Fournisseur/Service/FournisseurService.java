package tn.esprit.Fournisseur.Service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import tn.esprit.Fournisseur.Entity.Fournisseur;
import tn.esprit.Fournisseur.Repository.FournisseurRepository;

import java.util.List;

@Service
public class FournisseurService {
    private final FournisseurRepository fr;
    private final JavaMailSender mailSender;

    public FournisseurService(FournisseurRepository fr, JavaMailSender mailSender) {
        this.fr = fr;
        this.mailSender = mailSender;
    }

    public Fournisseur ajouterFournisseur(Fournisseur fournisseur) {
        Fournisseur savedFournisseur = fr.save(fournisseur);
        sendConfirmationEmail(savedFournisseur);
        return savedFournisseur;
    }

    private void sendConfirmationEmail(Fournisseur fournisseur) {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(fournisseur.getEmail());
            message.setSubject("Confirmation de création de compte fournisseur");

            String emailContent = "Bonjour " + fournisseur.getNomFournisseur() + ",\n\n" +
                    "Votre compte fournisseur a été créé avec succès.\n\n" +
                    "Détails du compte :\n" +
                    "Nom: " + fournisseur.getNomFournisseur() + "\n" +
                    "Adresse: " + fournisseur.getAdresse() + "\n" +
                    "Téléphone: " + fournisseur.getNumtel() + "\n\n" +
                    "Cordialement,\nL'équipe de support";

            message.setText(emailContent);

            mailSender.send(message);

            System.out.println("\n=== EMAIL ENVOYÉ AVEC SUCCÈS ===");
            System.out.println("À: " + fournisseur.getEmail());
            System.out.println("Sujet: Confirmation de création de compte fournisseur");
            System.out.println("Contenu:\n" + emailContent);
            System.out.println("===============================\n");
        } catch (Exception e) {
            System.err.println("\n!!! ERREUR D'ENVOI D'EMAIL !!!");
            System.err.println("À: " + fournisseur.getEmail());
            System.err.println("Erreur: " + e.getMessage());
            System.err.println("===============================\n");
        }
    }

    public List<Fournisseur> findAll() {
        return fr.findAll();
    }

    public Fournisseur updateFournisseur(long id, Fournisseur newFournisseur) {
        if (fr.findById(id).isPresent()) {
            Fournisseur fournisseur = fr.findById(id).get();
            fournisseur.setNomFournisseur(newFournisseur.getNomFournisseur());
            fournisseur.setAdresse(newFournisseur.getAdresse());
            fournisseur.setNumtel(newFournisseur.getNumtel());
            return fr.save(fournisseur);
        } else {
            return null;
        }
    }

    public String deleteFournisseur(long id) {
        if (fr.findById(id).isPresent()) {
            fr.deleteById(id);
            return "Fournisseur supprimé";
        } else {
            return "Fournisseur non supprimé";
        }
    }
}