package tn.esprit.Restaurant.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="Fournisseur")
public interface FournisseurClient {

    @GetMapping("/fournisseur/list")
    List<Fournisseur> getAllFournisseurs();

    }



