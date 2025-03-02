package com.example.promotionss.services;

import com.example.promotionss.Entities.Promotions;
import com.example.promotionss.repositories.promotions;
import org.springframework.stereotype.Service;

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
