package tn.esprit.Restaurant.OpenFeign;

import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "COMMANDE", url = "http://localhost:8084")
public interface CommandeClient {

    @RequestMapping("commande/list")
    public List<Commande> getAllListCommande();


}
