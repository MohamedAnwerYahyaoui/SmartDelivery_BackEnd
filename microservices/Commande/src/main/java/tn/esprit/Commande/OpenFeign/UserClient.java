package tn.esprit.Commande.OpenFeign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name="authService")
public interface UserClient {
}
