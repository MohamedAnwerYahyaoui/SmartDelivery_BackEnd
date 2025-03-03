package tn.esprit.Commande.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Commande.Entity.Commande;

public interface CommandeRepo extends JpaRepository<Commande,Long> {
}
