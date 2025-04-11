package tn.esprit.Commande.OpenFeign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(name = "client")
        //, url = "http://localhost:8066/client")
public interface ClientClient {

//    @GetMapping("/findbynom/{nom}")
//    ClientRequest findbynom(@PathVariable String nom);



    @GetMapping("/client/findbynom/{nom}")
    ClientRequest findbynom(@PathVariable String nom);


}
