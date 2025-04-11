package tn.esprit.authservice.config;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.cors.CorsConfiguration;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@RequiredArgsConstructor
public class WebSecurityConfiguration {

    private final JwtAuthConverter jwtAuthConverter;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }



    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Disable for simplicity (enable for production)
                .authorizeHttpRequests(auth -> auth
                        // use authentication login logout
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/logout").permitAll()
                        // User API Endpoints
                        .requestMatchers(HttpMethod.POST, "/users/add").permitAll()
                        .requestMatchers(HttpMethod.POST, "/users/addClient").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/users/*/send-verification-email").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/users/*").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/users/forgot-password").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/users/*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/*/roles").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/helper/*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/users/*/groups").permitAll()

                        // Role API Endpoints
                        .requestMatchers(HttpMethod.POST, "/roles/add").permitAll()
                        .requestMatchers(HttpMethod.GET, "/roles/all").permitAll()
                        .requestMatchers(HttpMethod.GET, "/roles/*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/roles/role/*").permitAll()
                        .requestMatchers(HttpMethod.GET, "/roles/id/*").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/roles/*").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/roles/assign/users/*").permitAll()
                        .requestMatchers(HttpMethod.PUT, "/roles/*").permitAll()
                        .requestMatchers(HttpMethod.DELETE, "/roles/remove/users/*").permitAll()
                        .requestMatchers("/api/v1/auth/**","/v3/api-docs/**","/v2/api-docs","/swagger-ui/**","/v3/api-docs","/swagger-ui.html").permitAll()

                        .anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(jwt -> jwt.jwtAuthenticationConverter(jwtAuthConverter))
                )
                .sessionManagement(session ->
                        session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }



}

