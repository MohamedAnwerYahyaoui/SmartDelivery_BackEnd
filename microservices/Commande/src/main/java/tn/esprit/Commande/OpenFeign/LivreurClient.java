package tn.esprit.Commande.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "livreur" , url = "localhost:8066")
public interface LivreurClient {

    @GetMapping("/{id}")
    LivreurRequest getLivreurById(@PathVariable Long id);


}
