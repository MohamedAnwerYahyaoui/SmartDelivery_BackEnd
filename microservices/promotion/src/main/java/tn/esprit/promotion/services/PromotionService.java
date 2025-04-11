package tn.esprit.promotion.services;

import org.springframework.stereotype.Service;
import tn.esprit.promotion.Entities.Promotions;
import tn.esprit.promotion.repositories.promotions;

import java.util.List;

@Service
public class PromotionService {

    private final promotions pr;

    public PromotionService(promotions pr) {
        this.pr = pr;
    }

    public List<Promotions> getAll(){
       return pr.findAll();
   }
   public Promotions add(Promotions prr){
        return pr.save(prr);
   }
}
