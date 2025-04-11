package tn.esprit.annonce.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import tn.esprit.annonce.Entity.Notification;
import tn.esprit.annonce.Repository.NotificationRepository;
import tn.esprit.annonce.Service.NotificationService;

import java.util.List;

@RestController
@RequestMapping("/annonce")
public class NotificationController {

    private final NotificationService nr;

    public NotificationController(NotificationService nr){
        this.nr=nr;
    }
    @GetMapping("/all")
    public ResponseEntity<List<Notification>> listNotification(){
        return new ResponseEntity<>(nr.findAll(), HttpStatus.OK);
    }




    @PostMapping("/ajouter")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Notification> createNotification(@RequestBody Notification notification) {
        return new ResponseEntity<>(nr.ajouterNotification(notification), HttpStatus.OK);
    }
    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Notification> updateNotification(@PathVariable(value = "id") long id,
                                                       @RequestBody Notification notification){
        return new ResponseEntity<>(nr.updateNotification(id, notification),
                HttpStatus.OK);
    }
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteNotification(@PathVariable(value = "id") long id) {
        return new ResponseEntity<>(nr.deleteNotification(id), HttpStatus.OK);
    }




}
