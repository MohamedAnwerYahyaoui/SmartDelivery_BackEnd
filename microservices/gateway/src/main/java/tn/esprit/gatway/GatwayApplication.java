package tn.esprit.gatway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class GatwayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatwayApplication.class, args);
	}


	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){

		return builder.routes()
				.route("Commande",r->r.path("/commande/**").uri("lb://Commande"))
		        .route("Fournisseur",r->r.path("/fournisseur/**").uri("lb://Fournisseur"))
				.route("Restaurant",r->r.path("/restaurant/**").uri("lb://Restaurant"))
				.route("Repas",r->r.path("/repas/**").uri("lb://Repas"))
				.route("promotion",r->r.path("/pr/**").uri("lb://promotion"))
				.route("AuthenticationMS",r->r.path("/auth/**").uri("lb://authService"))

				.route("annonce",r->r.path("/annonce/**").uri("lb://annonce"))
				.route("email-service", r -> r.path("/mail/**").uri("lb://email-service"))
				.route("client", r -> r.path("/client/**").uri("lb://client"))

				.route("Auth-swagger", r -> r.path("/auth-swagger/**")
						.filters(f -> f.rewritePath("/auth-swagger/(?<segment>.*)", "/${segment}"))
						.uri("lb://authService"))

				.build();
	}

}
