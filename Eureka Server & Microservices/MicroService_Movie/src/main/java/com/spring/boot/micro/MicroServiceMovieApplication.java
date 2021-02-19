package com.spring.boot.micro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class IrisiBrunoComp303Assignment4MicroServiceMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrisiBrunoComp303Assignment4MicroServiceMovieApplication.class, args);
		System.setProperty("spring.config.name", "movie-service");
		System.out.println("Movie Micro-service is ready....");	
	}	
}
