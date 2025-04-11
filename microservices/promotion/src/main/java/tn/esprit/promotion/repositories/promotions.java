package tn.esprit.promotion.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.promotion.Entities.Promotions;

@Repository
public interface promotions extends JpaRepository<Promotions, Long> {
}
