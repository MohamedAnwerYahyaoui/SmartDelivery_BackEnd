package com.example.promotionss;

import com.example.promotionss.Entities.Promotions;
import com.example.promotionss.repositories.promotions;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

@EnableDiscoveryClient


@SpringBootApplication
public class PromotionssApplication {

	public PromotionssApplication(promotions pr) {
		this.pr = pr;
	}

	public static void main(String[] args) {
		SpringApplication.run(PromotionssApplication.class, args);
	}


private final promotions pr;


@Bean
public ApplicationRunner init(){
return(args)->{
pr.save(new Promotions("description","2023-12-24","best offre",1200));
};
}

}
