package tn.esprit.Commande.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-service")
public interface EmailClient {

@PostMapping("/mail/send-email")
void sendEmail(@RequestBody EmailRequest emailRequest);
}
