package com.example.SpringCoreConceptesdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreConceptualisesApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringCoreConceptualisesApplication.class, args);
	}

	public SpringCoreConceptualisesApplication(UserService userService) {
		this.userService = userService;
	}

	private final UserService userService;

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userService.saveUser("Satya is the User");
	}

}