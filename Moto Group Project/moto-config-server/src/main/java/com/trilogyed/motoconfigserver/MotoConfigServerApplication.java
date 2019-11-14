package com.trilogyed.motoconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MotoConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MotoConfigServerApplication.class, args);
	}

}
