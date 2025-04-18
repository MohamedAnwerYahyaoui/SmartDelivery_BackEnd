package tn.esprit.Restaurant.Service;

import org.springframework.stereotype.Service;
import tn.esprit.Restaurant.Repository.RestaurantRepo;
import tn.esprit.Restaurant.entity.Restaurant;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    private final RestaurantRepo rr;

    public RestaurantService(RestaurantRepo rr){
        this.rr=rr;
    }

    public Restaurant ajouterRestaurant(Restaurant restaurant) {
        return rr.save(restaurant);
    }


    public List<Restaurant> findAll() {
        return rr.findAll();
    }

    public Restaurant toggleStatus(long id) {
        Restaurant restaurant = findRestaurant(id);
        restaurant.setStatus(!restaurant.getStatus());

        return rr.save(restaurant);
    }

    public Restaurant findRestaurant(long id) {
        return rr.findRestaurantByIdRestaurant(id);
    }





    public Restaurant updateRestaurant(long id, Restaurant newRestaurant) {
        if (rr.findById(id).isPresent()) {
            Restaurant restaurant = rr.findById(id).get();
            restaurant.setMantantTotale(newRestaurant.getMantantTotale());
            restaurant.setStatus(newRestaurant.getStatus());
            restaurant.setNomresto(newRestaurant.getNomresto());

            return rr.save(restaurant);
        } else
            return null;
    }


    public String deleteRestaurant(long id) {
        if (rr.findById(id).isPresent()) {
            rr.deleteById(id);
            return "Restaurant supprimé";
        } else
            return "Restaurant non supprimé";
    }



}
