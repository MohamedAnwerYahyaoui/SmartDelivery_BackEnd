package tn.esprit.Commande.OpenFeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


//@FeignClient(name = "client")
        //, url = "http://localhost:8066/client")
@FeignClient(name = "client", url = "http://localhost:8777/client")
public interface ClientClient {





    @GetMapping("/client/findbynomm/{nom}")
    ClientRequest findbynom(@PathVariable String nom);



    @GetMapping("/{id}")
    ClientRequest findById(@PathVariable Long id);


}
