package tn.esprit.Restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Restaurant.entity.repas;

public interface RepasRepository extends JpaRepository<repas,Long> {
}
