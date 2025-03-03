package tn.esprit.Restaurant.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Restaurant.Service.RepasService;
import tn.esprit.Restaurant.entity.repas;

import java.util.List;

@RestController
@RequestMapping("/repas")
public class RepasController {

    private final RepasService rs;

    public RepasController(RepasService rs){
        this.rs=rs;
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<repas>> listRepas(){
        return new ResponseEntity<>(rs.findAll(), HttpStatus.OK);
    }




    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<repas> createRepas(@RequestBody repas repass) {
        return new ResponseEntity<>(rs.ajouterRepas(repass), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<repas> updateRepas(@PathVariable(value = "id") long id,
                                                   @RequestBody repas repas){
        return new ResponseEntity<>(rs.updateRepas(id, repas),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteRepas(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(rs.deleteRepas(id), HttpStatus.OK);
    }

}
