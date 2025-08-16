package com.binitshrestha.lawyer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class LawyerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(LawyerServiceApplication.class, args);
	}

}
