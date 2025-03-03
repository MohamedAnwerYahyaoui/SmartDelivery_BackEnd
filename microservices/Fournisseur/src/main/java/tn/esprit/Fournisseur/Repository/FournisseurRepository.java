package tn.esprit.Fournisseur.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.Fournisseur.Entity.Fournisseur;
@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
}
