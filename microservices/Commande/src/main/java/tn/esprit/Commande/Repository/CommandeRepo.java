package tn.esprit.Commande.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Commande.Entity.Commande;
import tn.esprit.Commande.Entity.Status;

import java.util.List;

public interface CommandeRepo extends JpaRepository<Commande,Long> {
    List<Commande> findByStatus(Status status);
}
