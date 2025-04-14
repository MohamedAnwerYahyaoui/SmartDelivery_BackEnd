package tn.esprit.annonce.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import tn.esprit.annonce.Entity.Notification;

import java.security.Principal;

@Controller
public class NotificationWebSocketController {

    private final SimpMessagingTemplate messagingTemplate;

    @Autowired
    public NotificationWebSocketController(SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    @MessageMapping("/sendNotification")
    public void sendNotification(@Payload Notification notification, Principal principal) {
        // Si pas d'auth, principal = null => on met "demoUser"
        String username = (principal != null) ? principal.getName() : "demoUser";
        messagingTemplate.convertAndSendToUser(username, "/queue/notifications", notification);
    }

}
