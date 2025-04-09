package tn.esprit.annonce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication

public class AnnonceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnnonceApplication.class, args);
	}

}
