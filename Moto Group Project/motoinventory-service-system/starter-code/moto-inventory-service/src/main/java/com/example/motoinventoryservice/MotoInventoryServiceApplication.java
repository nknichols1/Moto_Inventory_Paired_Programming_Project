package com.example.motoinventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
public class MotoInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotoInventoryServiceApplication.class, args);
	}

}
