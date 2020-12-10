package io.plantgreeter.greetingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableWebSecurity
@EnableResourceServer
@EnableOAuth2Client
@EnableDiscoveryClient
@SpringBootApplication
public class GreetingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingServerApplication.class, args);
	}

}
