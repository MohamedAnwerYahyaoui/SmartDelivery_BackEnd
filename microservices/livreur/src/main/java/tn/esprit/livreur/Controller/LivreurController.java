package tn.esprit.livreur.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.livreur.Service.LivreurService;
import tn.esprit.livreur.entity.Livreur;
import tn.esprit.livreur.openfeign.LocalisationDTO;


import java.util.List;

@RestController
@RequestMapping("/livreur")
public class LivreurController {

    private final LivreurService ls;


    public LivreurController(LivreurService ls) {
        this.ls = ls;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Livreur>> listLivreur(){
        return new ResponseEntity<>(ls.findAll(), HttpStatus.OK);
    }






    @GetMapping("/{id}")
    public ResponseEntity<Livreur> getLivreurById(@PathVariable Long id) {
        Livreur livreur = ls.findById(id);
        if (livreur != null) {
            return ResponseEntity.ok(livreur);
        } else {
            return ResponseEntity.notFound().build();
        }
    }





    @GetMapping("/localiser-restaurant")
    public ResponseEntity<LocalisationDTO> getLocalisationRestaurant(@RequestParam String nom) {
        return ResponseEntity.ok(ls.rechercherLocalisationParNom(nom));
    }











    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Livreur> createLivreur(@RequestBody Livreur livreur) {
        return new ResponseEntity<>(ls.ajouterLivreur(livreur), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Livreur> updateLivreur(@PathVariable(value = "id") long id,
                                                         @RequestBody Livreur livreur){
        return new ResponseEntity<>(ls.updateLivreur(id, livreur),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteLivreur(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(ls.deleteLivreur(id), HttpStatus.OK);
    }






}
