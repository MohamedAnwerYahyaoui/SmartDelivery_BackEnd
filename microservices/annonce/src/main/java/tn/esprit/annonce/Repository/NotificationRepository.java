package tn.esprit.annonce.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.annonce.Entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification,Long> {
}
