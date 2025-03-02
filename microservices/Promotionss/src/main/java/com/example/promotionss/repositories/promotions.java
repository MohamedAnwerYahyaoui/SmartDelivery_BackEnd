package com.example.promotionss.repositories;

import com.example.promotionss.Entities.Promotions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface promotions extends JpaRepository<Promotions, Long> {
}
