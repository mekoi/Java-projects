package com.spring.boot.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IrisiBrunoComp303Assignment4MicroServiceTicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrisiBrunoComp303Assignment4MicroServiceTicketApplication.class, args);
		System.setProperty("spring.config.name", "ticket-service");
		System.out.println("Ticket Micro-service is ready....");	
	}

}
