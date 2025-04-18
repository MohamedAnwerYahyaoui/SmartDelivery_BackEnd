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
@CrossOrigin(origins = "http://localhost:4200",
        allowedHeaders = "*",
        methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT,
                RequestMethod.DELETE, RequestMethod.PATCH, RequestMethod.OPTIONS})
public class RestaurantController {

    private final RestaurantService rs;

    public RestaurantController(RestaurantService rs){
        this.rs=rs;
    }


    @GetMapping("/all")
    public ResponseEntity<List<Restaurant>> listRestaurant(){
        return new ResponseEntity<>(rs.findAll(), HttpStatus.OK);
    }




    @PatchMapping("/{id}/toggle-status")
    public ResponseEntity<Restaurant> toggleRestaurantStatus(@PathVariable Long id) {
        try {
            Restaurant updated = rs.toggleStatus(id);
            return ResponseEntity.ok(updated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }






    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(rs.ajouterRestaurant(restaurant), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") long id,
                                                       @RequestBody Restaurant restaurant) {
        return new ResponseEntity<>(rs.updateRestaurant(id, restaurant),
                HttpStatus.OK);
    }
    @GetMapping(value = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Restaurant> findRestaurant(@PathVariable(value = "id") long id
                                                      ){
        return new ResponseEntity<>(rs.findRestaurant(id),
                HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteRestaurant(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(rs.deleteRestaurant(id), HttpStatus.OK);
    }



}
