package com.rafael.skip.challenge.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.rafael.skip.challenge.model", "com.rafael.skip.challenge.service",
"com.rafael.skip.challenge.repository" })

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
