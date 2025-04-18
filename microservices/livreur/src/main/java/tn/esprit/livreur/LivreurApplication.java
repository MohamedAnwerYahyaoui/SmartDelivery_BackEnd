package tn.esprit.livreur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class LivreurApplication {

	public static void main(String[] args) {
		SpringApplication.run(LivreurApplication.class, args);
	}

}
