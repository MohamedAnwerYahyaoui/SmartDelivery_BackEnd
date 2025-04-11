package tn.esprit.Commande.Controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Commande.Entity.Commande;
import tn.esprit.Commande.Entity.Status;
import tn.esprit.Commande.Repository.CommandeRepo;
import tn.esprit.Commande.Service.CommandeService;

import javax.swing.text.Document;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/commande")
public class CommandeController {

    private final CommandeService commandeService;
    private final CommandeRepo commandeRepo;

    public CommandeController(CommandeService commandeService, CommandeRepo commandeRepo){
        this.commandeService=commandeService;
        this.commandeRepo = commandeRepo;
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

    @GetMapping("/total-amount")
    public ResponseEntity<Float> getTotalAmount(@RequestParam(value = "status", required = false) Status status) {
        return new ResponseEntity<>(commandeService.calculateTotalAmount(status), HttpStatus.OK);
    }
    @GetMapping("/status")
    public ResponseEntity<List<Commande>> getCommandesByStatus(@RequestParam(value = "status", required = false) Status status) {
        if (status == null) {
            return new ResponseEntity<>(commandeService.findAll(), HttpStatus.OK);
        }
        return new ResponseEntity<>(commandeService.findByStatus(status), HttpStatus.OK);
    }
    @GetMapping("/statistics")
    public ResponseEntity<Map<String, Object>> getStatistics() {
        return new ResponseEntity<>(commandeService.getStatistics(), HttpStatus.OK);
    }

}




