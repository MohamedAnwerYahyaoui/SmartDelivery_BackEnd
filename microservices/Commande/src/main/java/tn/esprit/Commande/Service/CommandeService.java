package tn.esprit.Commande.Service;

import org.springframework.stereotype.Service;
import tn.esprit.Commande.Entity.Commande;
import tn.esprit.Commande.Entity.Status;
import tn.esprit.Commande.Repository.CommandeRepo;

import java.util.List;

@Service
public class CommandeService {

    private final CommandeRepo commandeRepo;
    private CommandeRepo cr;

    public CommandeService(CommandeRepo cr, CommandeRepo commandeRepo){
        this.cr=cr;
        this.commandeRepo = commandeRepo;
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

    public float calculateTotalAmount(Status status) {
        List<Commande> commandes = (status != null) ? commandeRepo.findByStatus(status) : commandeRepo.findAll();
        return (float) commandes.stream().mapToDouble(Commande::getMantantTotal).sum();
    }
}

















