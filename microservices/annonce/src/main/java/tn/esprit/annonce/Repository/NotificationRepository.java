package tn.esprit.annonce.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.annonce.Entity.Notification;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
    List<Notification> findByNomClientOrderByDateDesc(String nomClient);


}
