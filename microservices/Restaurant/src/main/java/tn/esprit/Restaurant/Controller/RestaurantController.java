package tn.esprit.Restaurant.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Restaurant.Service.RestaurantService;
import tn.esprit.Restaurant.entity.Restaurant;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService rs;

    public RestaurantController(RestaurantService rs){
        this.rs=rs;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Restaurant>> listRestaurant(){
        return new ResponseEntity<>(rs.findAll(), HttpStatus.OK);
    }




    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(rs.ajouterRestaurant(restaurant), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") long id,
                                                   @RequestBody Restaurant restaurant){
        return new ResponseEntity<>(rs.updateRestaurant(id, restaurant),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteRestaurant(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(rs.deleteRestaurant(id), HttpStatus.OK);
    }



}
