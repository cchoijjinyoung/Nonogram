package com.logic.nemonemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class NemonemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NemonemoApplication.class, args);
	}

}
