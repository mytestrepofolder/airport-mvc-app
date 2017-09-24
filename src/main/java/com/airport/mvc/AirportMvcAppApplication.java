package com.airport.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AirportMvcAppApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(AirportMvcAppApplication.class, args);
	}

	// Added configure to enable deployement in a Tomcat Server
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		// TODO Auto-generated method stub
		return builder.sources(AirportMvcAppApplication.class);
	}
}
