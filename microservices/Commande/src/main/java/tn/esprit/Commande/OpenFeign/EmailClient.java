package tn.esprit.Commande.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "email-service")
        //, url = "http://localhost:8081")
public interface EmailClient {

//    @PostMapping("/send-email")
//    void sendEmail(@RequestBody EmailRequest emailRequest);
@PostMapping("/mail/send-email")  // Utilisez le même path que dans le gateway
void sendEmail(@RequestBody EmailRequest emailRequest);
}
