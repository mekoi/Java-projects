package com.spring.boot.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootJpaCloudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaCloudApplication.class, args);
		System.out.println("Eureka Server started");
	}

}
