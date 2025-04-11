package tn.esprit.Fournisseur.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name = "Restaurant")

public interface RestaurantClient {


        @GetMapping("/restaurant/find/{id}")
        Restaurant findRestaurantById(@PathVariable("id") Long id);

    }


