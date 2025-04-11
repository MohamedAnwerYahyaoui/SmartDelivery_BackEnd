package tn.esprit.promotion.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.promotion.Entities.Promotions;

import java.util.Optional;

@Repository
public interface promotions extends JpaRepository<Promotions, Long> {
    Optional<Promotions> findById(Long id);
}
