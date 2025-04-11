package tn.esprit.Fournisseur.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.Fournisseur.Entity.Fournisseur;

import java.util.List;

@Repository
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    @Query("SELECT f.adresse AS region, COUNT(f) FROM Fournisseur f GROUP BY f.adresse")
    List<Object[]> countByRegion();
}
