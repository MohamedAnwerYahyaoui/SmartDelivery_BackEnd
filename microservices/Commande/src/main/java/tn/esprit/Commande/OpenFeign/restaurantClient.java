package tn.esprit.Commande.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@FeignClient(name="Restaurant")
public interface restaurantClient {

    @GetMapping("/restaurant/find/{id}")
    Restaurant findRestaurantById(@PathVariable("id") Long id);

    }




