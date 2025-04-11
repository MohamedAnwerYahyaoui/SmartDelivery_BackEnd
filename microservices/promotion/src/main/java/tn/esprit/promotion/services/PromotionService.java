package tn.esprit.promotion.services;

import org.springframework.stereotype.Service;
import tn.esprit.promotion.Entities.Promotions;
import tn.esprit.promotion.repositories.promotions;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PromotionService {

    private final promotions pr;


    public PromotionService(promotions pr) {
        this.pr = pr;
    }

    public List<Promotions> getAll() {
        return pr.findAll();
    }

    public Promotions add(Promotions prr) {
        return pr.save(prr);
    }

    public boolean isPromotionValid(Promotions promotion) {
        LocalDateTime now = LocalDateTime.now();
        return !now.isBefore(promotion.getDate());
    }

    public Promotions findById(Long id) {
        return pr.findById(id)
                .orElseThrow(() -> new RuntimeException("Promotion not found with id: " + id));
    }

        public double applyDynamicPricing(Promotions promotion, double originalPrice) {
            // Your existing logic
            if (originalPrice > 100) {
                return originalPrice * 0.90;
            } else if (originalPrice > 50) {
                return originalPrice * 0.95;
            }
            return originalPrice;
        }
}