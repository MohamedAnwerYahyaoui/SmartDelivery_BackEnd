package tn.esprit.Commande.Service;

import org.springframework.stereotype.Service;
import tn.esprit.Commande.Entity.Commande;
import tn.esprit.Commande.Entity.Status;
import tn.esprit.Commande.Repository.CommandeRepo;

import java.util.*;
import java.util.logging.Logger;

@Service
public class CommandeService {
    private static final Logger logger = Logger.getLogger(CommandeService.class.getName());
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
    public List<Commande> findByStatus(Status status) {
        return commandeRepo.findByStatus(status);
    }
    public Map<String, Object> getStatistics() {
        Map<String, Object> stats = new HashMap<>();

        // Count by status
        Map<String, Long> countByStatus = new HashMap<>();
        for (Status status : Status.values()) {
            long count = commandeRepo.findByStatus(status).size();
            countByStatus.put(status.toString(), count);
        }
        stats.put("countByStatus", countByStatus);

        // Average order amount
        List<Commande> allCommandes = commandeRepo.findAll();
        double averageAmount = allCommandes.stream()
                .mapToDouble(Commande::getMantantTotal)
                .average()
                .orElse(0.0);
        stats.put("averageAmount", averageAmount);

        logger.info("Statistics computed: " + stats);
        return stats;
    }

}

















