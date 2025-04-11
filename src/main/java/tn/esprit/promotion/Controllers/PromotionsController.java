package tn.esprit.promotion.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.promotion.Entities.Promotions;
import tn.esprit.promotion.repositories.promotions;
import tn.esprit.promotion.services.PromotionService;

import java.util.List;

@RequestMapping("/pr")
@RestController
public class PromotionsController {
    private final PromotionService sr;
    private final promotions p;

    public PromotionsController(PromotionService sr, promotions p) {
        this.sr = sr;
        this.p = p;
    }

    @PostMapping("/addP")
    public Promotions add(Promotions pr) {
        return sr.add(pr);
    }

    @GetMapping("/getP")
    public List<Promotions> getall() {
        return sr.getAll();
    }


    @DeleteMapping("/delete/{id}")
    public void delete(Long id) {
        p.deleteById(id);
    }




    @GetMapping("/hello")
    public String sayHello() {
        return "Hello I'm Microservice promotions";
    }




    @GetMapping("/{id}/validate")
    public ResponseEntity<Boolean> checkPromotionValidity(@PathVariable Long id) {
        Promotions promotion = sr.findById(id);
        return ResponseEntity.ok(sr.isPromotionValid(promotion));
    }

    @GetMapping("/calculate-discount")
    public double calculateDiscount(
            @RequestParam String offre,
            @RequestParam double prix
    ) {
        // Create a temporary Promotion object (or fetch from DB)
        Promotions promotion = new Promotions();
        promotion.setOffre(offre);
        promotion.setPrix((int) prix); // Assuming 'prix' is the original price

        return sr.applyDynamicPricing(promotion, prix);
    }
}

