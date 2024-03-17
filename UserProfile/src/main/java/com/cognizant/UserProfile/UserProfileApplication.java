package com.cognizant.UserProfile;

import javax.xml.transform.Source;

import org.apache.catalina.filters.CorsFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;

@SpringBootApplication
@EnableDiscoveryClient
@OpenAPIDefinition
public class UserProfileApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserProfileApplication.class, args);
	}
	


}
