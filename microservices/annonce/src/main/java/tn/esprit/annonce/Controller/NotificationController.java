package tn.esprit.annonce.Controller;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.annonce.Entity.GroupNotification;
import tn.esprit.annonce.Entity.Notification;
import tn.esprit.annonce.Service.NotificationService;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/notification")
public class NotificationController {

    private final NotificationService nr;


    public NotificationController(NotificationService nr){
        this.nr=nr;

    }
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> listNotifications(){
        return new ResponseEntity<>(nr.findAll(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notification> getNotification(@PathVariable("id") Long id) {
        Notification notification = nr.findById(id);
        if (notification != null) {
            return new ResponseEntity<>(notification, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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
    // Endpoint pour marquer une notification comme lue
    @PostMapping(value = "/{id}/markAsRead", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notification> markNotificationAsRead(@PathVariable("id") Long id) {
        Notification notification = nr.markAsRead(id);
        if (notification != null) {
            return new ResponseEntity<>(notification, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Endpoint pour marquer une notification comme non lue
    @PostMapping(value = "/{id}/markAsUnread", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Notification> markNotificationAsUnread(@PathVariable("id") Long id) {
        Notification notification = nr.markAsUnread(id);
        if (notification != null) {
            return new ResponseEntity<>(notification, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/history/{nomClient}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> getNotificationHistory(@PathVariable("nomClient") String nomClient) {
        List<Notification> history = nr.getHistory(nomClient);
        return new ResponseEntity<>(history, HttpStatus.OK);
    }
    // Endpoint pour l'envoi groupé de notifications personnalisées
    @PostMapping(value = "/group", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Notification>> sendGroupNotifications(@RequestBody GroupNotification request) {
        List<Notification> notifications = nr.sendGroupNotifications(request);
        return new ResponseEntity<>(notifications, HttpStatus.OK);
    }
    @GetMapping(value = "/stats", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Integer>> getNotificationStats() {
        Map<String, Integer> stats = nr.getNotificationStats();
        return new ResponseEntity<>(stats, HttpStatus.OK);
    }


}








