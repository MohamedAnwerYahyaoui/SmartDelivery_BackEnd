package tn.esprit.annonce.Service;

import org.springframework.stereotype.Service;
import tn.esprit.annonce.Entity.Notification;
import tn.esprit.annonce.Repository.NotificationRepository;

import java.util.List;

@Service
public class NotificationService {


    private final NotificationRepository nr;

    public NotificationService(NotificationRepository nr){
        this.nr=nr;
    }
    public Notification ajouterNotification(Notification notification) {
        return nr.save(notification);
    }


    public List<Notification> findAll() {
        return nr.findAll();
    }


    public Notification updateNotification(long id, Notification newNotif) {
        if (nr.findById(id).isPresent()) {
            Notification notification = nr.findById(id).get();
            notification.setContenu(newNotif.getContenu());
            notification.setNomClient(newNotif.getNomClient());
            notification.setDate(newNotif.getDate());


            return nr.save(notification);
        } else
            return null;
    }


    public String deleteNotification(long id) {
        if (nr.findById(id).isPresent()) {
            nr.deleteById(id);
            return "Notification supprimé";
        } else
            return "Notification non supprimé";
    }


}
