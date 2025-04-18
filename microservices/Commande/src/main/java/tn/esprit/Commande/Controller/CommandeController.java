package tn.esprit.Commande.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Commande.Entity.Commande;
import tn.esprit.Commande.Service.CommandeService;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandeController {

    private final CommandeService commandeService;

    public CommandeController(CommandeService commandeService){
        this.commandeService=commandeService;
    }

    @GetMapping("/list")
    public ResponseEntity<List<Commande>> listCommande(){
        return new ResponseEntity<>(commandeService.findAll(), HttpStatus.OK);
    }




    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Commande> createCommande(@RequestBody Commande commande) {
        return new ResponseEntity<>(commandeService.ajouterCommande(commande), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Commande> updateCommande(@PathVariable(value = "id") long id,
                                                 @RequestBody Commande commande){
        return new ResponseEntity<>(commandeService.updateCommande(id, commande),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteCommande(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(commandeService.deleteCommande(id), HttpStatus.OK);
    }



    @PostMapping(value = "/{id}/{idc}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public void confirmerCommande(@PathVariable Long id,@PathVariable Long idc){

        commandeService.confirmerCommande(id, idc);
    }
    @PostMapping("/commande/{commandeId}/livreur/{livreurId}")
    public ResponseEntity<?> affecterCommandeALivreur(@PathVariable Long commandeId, @PathVariable Long livreurId) {
        commandeService.affecterCommandeALivreur(commandeId, livreurId);
        return ResponseEntity.ok("Commande affectée avec succès");
    }
}







