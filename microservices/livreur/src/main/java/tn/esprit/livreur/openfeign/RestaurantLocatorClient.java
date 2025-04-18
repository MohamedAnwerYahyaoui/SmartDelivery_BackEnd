package tn.esprit.livreur.openfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ApiGoogleMaps", url = "http://localhost:8002")
public interface RestaurantLocatorClient {

    @GetMapping("/localiser")
    LocalisationDTO getLocalisation(@RequestParam("restaurant_name") String restaurantName);
}