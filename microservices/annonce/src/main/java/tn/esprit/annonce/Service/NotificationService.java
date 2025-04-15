package tn.esprit.annonce.Service;
import org.springframework.stereotype.Service;
import tn.esprit.annonce.Entity.GroupNotification;
import tn.esprit.annonce.Entity.IndividualNotification;
import tn.esprit.annonce.Entity.Notification;
import tn.esprit.annonce.Repository.NotificationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
    public Notification findById(long id) {
        return nr.findById(id).orElse(null);
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
            return "notification supprimé";
        } else
            return "notification non supprimé";
    }
    //  une notification comme lue
    public Notification markAsRead(long id) {
        Notification notification = findById(id);
        if (notification != null) {
            notification.setRead(true);
            return nr.save(notification);
        }
        return null;
    }

    //  une notification comme non lue
    public Notification markAsUnread(long id) {
        Notification notification = findById(id);
        if (notification != null) {
            notification.setRead(false);
            return nr.save(notification);
        }
        return null;

    }

    // Récupérer l'historique des notifications pour un client donné
    public List<Notification> getHistory(String nomClient) {
        return nr.findByNomClientOrderByDateDesc(nomClient);
    }
    // Méthode pour l'envoi groupé de notifications personnalisées
    public List<Notification> sendGroupNotifications(GroupNotification request) {
        List<Notification> createdNotifications = new ArrayList<>();
        String template = request.getTemplate();
        // Pour chaque notification individuelle dans la requête groupée
        for (IndividualNotification individual : request.getNotifications()) {
            // Remplacer les placeholders du template par les valeurs du map de données
            String personalizedContent = personalizeTemplate(template, individual.getData());
            Notification notification = new Notification();
            notification.setNomClient(individual.getNomClient());
            notification.setContenu(personalizedContent);
            notification.setDate(new Date());
            notification.setRead(false);
            createdNotifications.add(nr.save(notification));
        }
        return createdNotifications;
    }

    // Méthode utilitaire pour effectuer la substitution des placeholders
    private String personalizeTemplate(String template, Map<String, String> data) {
        String result = template;
        for (Map.Entry<String, String> entry : data.entrySet()) {
            String placeholder = "{" + entry.getKey() + "}";
            result = result.replace(placeholder, entry.getValue());
        }
        return result;
    }
    // Méthode pour récupérer les statistiques des notifications
    public Map<String, Integer> getNotificationStats() {
        List<Notification> notifications = nr.findAll();
        int total = notifications.size();
        int readCount = (int) notifications.stream().filter(Notification::isRead).count();
        int unreadCount = total - readCount;
        return Map.of(
                "total", total,
                "read", readCount,
                "unread", unreadCount
        );
    }


}