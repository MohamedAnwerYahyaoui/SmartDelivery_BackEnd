package tn.esprit.Restaurant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.Restaurant.entity.Restaurant;

public interface RestaurantRepo extends JpaRepository<Restaurant,Long> {


    Restaurant findRestaurantByIdRestaurant(long id);

}
