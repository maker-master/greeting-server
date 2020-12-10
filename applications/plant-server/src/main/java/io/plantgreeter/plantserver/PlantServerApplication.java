package io.plantgreeter.plantserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@EnableWebSecurity
@EnableResourceServer
@EnableOAuth2Client
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class PlantServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlantServerApplication.class, args);
	}

	@Bean
	public GreetingClient greetingClient(RestOperations restOperations,
										 @Value("${greeting.server.endpoint}") String greetingServerEndpoint) {
		return new GreetingClient(restOperations, greetingServerEndpoint);
	}

}
