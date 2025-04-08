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

		return builder.routes().route("Commande",r->r.path("/commandes/**").uri("lb://Commande"))
		.route("Fournisseur",r->r.path("/fournisseur/**").uri("lb://Fournisseur"))
				.route("Restaurant",r->r.path("/restaurant/**").uri("lb://Restaurant"))
				.route("Repas",r->r.path("/repas/**").uri("lb://Repas"))
				.route("Notification",r->r.path("/notification/**").uri("lb://Notification"))
				.route("AuthenticationMS",r->r.path("/auth/**").uri("lb://authService"))

				.route("Commande-swagger", r -> r.path("/commande-swagger/**")
						.filters(f -> f.rewritePath("/commande-swagger/(?<segment>.*)", "/${segment}"))
						.uri("lb://Commande"))

				.route("Fournisseur-swagger", r -> r.path("/fournisseur-swagger/**")
						.filters(f -> f.rewritePath("/fournisseur-swagger/(?<segment>.*)", "/${segment}"))
						.uri("lb://Fournisseur"))

				.route("Restaurant-swagger", r -> r.path("/restaurant-swagger/**")
						.filters(f -> f.rewritePath("/restaurant-swagger/(?<segment>.*)", "/${segment}"))
						.uri("lb://Restaurant"))

				.route("Repas-swagger", r -> r.path("/repas-swagger/**")
						.filters(f -> f.rewritePath("/repas-swagger/(?<segment>.*)", "/${segment}"))
						.uri("lb://Repas"))

				.route("Notification-swagger", r -> r.path("/notification-swagger/**")
						.filters(f -> f.rewritePath("/notification-swagger/(?<segment>.*)", "/${segment}"))
						.uri("lb://Notification"))

				.route("Auth-swagger", r -> r.path("/auth-swagger/**")
						.filters(f -> f.rewritePath("/auth-swagger/(?<segment>.*)", "/${segment}"))
						.uri("lb://authService"))


				.build();
	}

}
