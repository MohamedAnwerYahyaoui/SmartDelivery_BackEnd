package tn.esprit.annonce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // Active un broker simple pour diffuser les messages aux clients abonnés
        config.enableSimpleBroker("/topic", "/queue"); // Ajout de "/queue" pour les messages privés
        // Définir un préfixe pour les messages destinés à un utilisateur particulier
        config.setUserDestinationPrefix("/user");
        // Préfixe pour les messages envoyés par les clients à l'application
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // Endpoint pour la connexion WebSocket avec SockJS (n'oubliez pas withSockJS())
        registry.addEndpoint("/ws-notifications")
                .setAllowedOriginPatterns("*")
                .withSockJS();
    }
}
