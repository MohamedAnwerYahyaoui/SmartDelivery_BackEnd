package tn.esprit.livreur.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.livreur.entity.Livreur;

@Repository
public interface LivreurRepo extends JpaRepository<Livreur,Long> {
}
