package com.example.SpringCoreConceptesdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreConceptesdemoApplication implements CommandLineRunner {
	public static void main(String[] args) {
		SpringApplication.run(SpringCoreConceptesdemoApplication.class, args);
	}
	UserService userService = new UserService();
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		userService.saveUser("Satya");
	}

}