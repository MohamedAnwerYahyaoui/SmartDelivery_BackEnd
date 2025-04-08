package tn.esprit.authservice.services.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.keycloak.admin.client.Keycloak;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;

import org.springframework.web.reactive.function.client.WebClient;
import tn.esprit.authservice.models.LoginRecord;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl {

    @Value("${app.keycloak.serverUrl}")
    private String keycloakUrl;

    @Value("${app.keycloak.realm}")
    private String realm;

    @Value("${app.keycloak.admin.clientId}")
    private String clientId;

    @Value("${app.keycloak.admin.clientSecret}")
    private String clientSecret;




    private final WebClient webClient = WebClient.create();

    public ResponseEntity<?> login(LoginRecord request) {
        String tokenUrl = String.format("%s/realms/%s/protocol/openid-connect/token",
                keycloakUrl, realm);

        return webClient.post()
                .uri(tokenUrl)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(
                        "grant_type=password&" +
                                "client_id=" + clientId + "&" +
                                "client_secret=" + clientSecret + "&" +
                                "username=" + request.username() + "&" +
                                "password=" + request.password()
                )
                .retrieve()
                .toEntity(Object.class)
                .block();
    }

    public ResponseEntity<?> logout(String refreshToken) {
        String logoutUrl = String.format("%s/realms/%s/protocol/openid-connect/logout",
                keycloakUrl, realm);

        return webClient.post()
                .uri(logoutUrl)
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .bodyValue(
                        "client_id=" + clientId + "&" +
                                "client_secret=" + clientSecret + "&" +
                                "refresh_token=" + refreshToken
                )
                .retrieve()
                .toEntity(Object.class)
                .block();
    }
}
