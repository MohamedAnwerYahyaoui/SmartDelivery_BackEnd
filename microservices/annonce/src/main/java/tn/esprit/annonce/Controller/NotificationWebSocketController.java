package tn.esprit.annonce.Controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import tn.esprit.annonce.Entity.Notification;

@Controller
public class NotificationWebSocketController {

    // Quand un message est envoyé à "/app/sendNotification",
    // il est diffusé à tous les abonnés du topic "/topic/notifications"
    @MessageMapping("/sendNotification")
    @SendTo("/topic/notifications")
    public Notification broadcastNotification(Notification notification) throws Exception {
        // Optionnel : simuler un délai de traitement
        Thread.sleep(500);
        return notification;
    }
}
