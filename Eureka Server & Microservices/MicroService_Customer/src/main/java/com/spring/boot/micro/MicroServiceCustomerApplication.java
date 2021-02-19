package com.spring.boot.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IrisiBrunoComp303Assignment4MicroServiceCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrisiBrunoComp303Assignment4MicroServiceCustomerApplication.class, args);
		System.setProperty("spring.config.name", "customer-service");
		System.out.println("Customer Micro-service is ready....");	
	}
}
