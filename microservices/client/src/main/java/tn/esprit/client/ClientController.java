package tn.esprit.client;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.client.Entity.Client;

import java.util.List;
@RestController
@RequestMapping("/client")
public class ClientController {



        private final ClientService clientService;

        public ClientController(ClientService clientService){
            this.clientService=clientService;
        }

        @GetMapping("/list")
        public ResponseEntity<List<Client>> listClient(){
            return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
        }




        @PostMapping("/ajouter")
        @ResponseStatus(HttpStatus.CREATED)
        public ResponseEntity<Client> createClient(@RequestBody Client client) {
            return new ResponseEntity<>(clientService.ajouterClient(client), HttpStatus.OK);
        }
        @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<Client> updateClient(@PathVariable(value = "id") long id,
                                                       @RequestBody Client client){
            return new ResponseEntity<>(clientService.updateClient(id, client),
                    HttpStatus.OK);
        }
        @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
        @ResponseStatus(HttpStatus.OK)
        public ResponseEntity<String> deleteClient(@PathVariable(value = "id") long id) {
            return new ResponseEntity<>(clientService.deleteClient(id), HttpStatus.OK);
        }




    @GetMapping("/findbynom/{nom}")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Client> findbynom(@PathVariable String nom) {
        return new ResponseEntity<>(clientService.findBynom(nom), HttpStatus.OK);
    }






    }










