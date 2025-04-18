package tn.esprit.Fournisseur.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.Fournisseur.Entity.Fournisseur;
import tn.esprit.Fournisseur.Service.FournisseurService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fournisseur")
public class FournisseurController {
    private final FournisseurService fournisseurService;

    public FournisseurController(FournisseurService fournisseurService) {
        this.fournisseurService = fournisseurService;
        System.out.println("Controller Fournisseur initialisé avec service d'email, PDF et Excel");
    }

    @GetMapping("/list")
    public ResponseEntity<List<Fournisseur>> listFournisseur() {
        System.out.println("Récupération de la liste des fournisseurs");
        return new ResponseEntity<>(fournisseurService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Fournisseur> createFournisseur(@RequestBody Fournisseur fournisseur) {
        System.out.println("Tentative de création d'un nouveau fournisseur: " + fournisseur.getNomFournisseur());
        ResponseEntity<Fournisseur> response = new ResponseEntity<>(fournisseurService.ajouterFournisseur(fournisseur), HttpStatus.OK);
        System.out.println("Fournisseur créé avec succès: " + fournisseur.getNomFournisseur());
        return response;
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable(value = "id") long id,
                                                         @RequestBody Fournisseur fournisseur) {
        System.out.println("Tentative de mise à jour du fournisseur ID: " + id);
        ResponseEntity<Fournisseur> response = new ResponseEntity<>(fournisseurService.updateFournisseur(id, fournisseur), HttpStatus.OK);
        System.out.println("Fournisseur mis à jour avec succès ID: " + id);
        return response;
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteFournisseur(@PathVariable(value = "id") long id) {
        System.out.println("Tentative de suppression du fournisseur ID: " + id);
        ResponseEntity<String> response = new ResponseEntity<>(fournisseurService.deleteFournisseur(id), HttpStatus.OK);
        System.out.println("Résultat de la suppression: " + response.getBody());
        return response;
    }

    @GetMapping(value = "/{id}/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> generatePdf(@PathVariable long id) {
        System.out.println("Génération PDF pour le fournisseur ID: " + id);
        return fournisseurService.generateFournisseurPdf(id);
    }

    @GetMapping(value = "/{id}/excel", produces = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet")
    public ResponseEntity<byte[]> generateExcel(@PathVariable long id) {
        System.out.println("Génération Excel pour le fournisseur ID: " + id);
        return fournisseurService.generateFournisseurExcel(id);
    }
    @GetMapping("/statistiques")
    public ResponseEntity<Map<String, Object>> getStatistiques() {
        System.out.println("Récupération des statistiques des fournisseurs");
        return new ResponseEntity<>(fournisseurService.getStatistiques(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}/qrcode", produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<byte[]> generateQRCode(@PathVariable long id) {
        System.out.println("Génération QR Code pour le fournisseur ID: " + id);
        return fournisseurService.generateFournisseurQRCode(id);
    }
}