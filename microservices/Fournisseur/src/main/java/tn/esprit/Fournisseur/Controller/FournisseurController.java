package tn.esprit.Fournisseur.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Fournisseur.Entity.Fournisseur;
import tn.esprit.Fournisseur.Service.FournisseurService;

import java.util.List;
@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService){
        this.fournisseurService=fournisseurService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Fournisseur>> listFournisseur(){
        return new ResponseEntity<>(fournisseurService.findAll(), HttpStatus.OK);
    }




    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur) {
        return new ResponseEntity<>(fournisseurService.ajouterFournisseur(fournisseur), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable(value = "id") long id,
                                                   @RequestBody Fournisseur fournisseur){
        return new ResponseEntity<>(fournisseurService.updateFournisseur(id, fournisseur),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFournisseur(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(fournisseurService.deleteFournisseur(id), HttpStatus.OK);
    }

}
