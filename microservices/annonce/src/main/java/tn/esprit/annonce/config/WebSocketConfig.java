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
        // Active un broker simple pour diffuser les messages aux clients abonnés sur le topic "/topic"
        config.enableSimpleBroker("/topic");
        // Préfixe pour les messages envoyés par les clients à l'application (destinations de type "/app")
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // L'endpoint que les clients utiliseront pour se connecter au WebSocket avec SockJS en fallback
        registry.addEndpoint("/ws-notifications").setAllowedOriginPatterns("*");
    }
}

