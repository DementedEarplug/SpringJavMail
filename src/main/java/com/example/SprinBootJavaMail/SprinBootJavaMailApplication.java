package com.example.SprinBootJavaMail;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Allows class to serve rests endpoints
public class SprinBootJavaMailApplication {

	public static void main(String[] args) {
		SpringApplication.run(SprinBootJavaMailApplication.class, args);
		System.out.println("Hello world!");
	}

	@GetMapping //Enables GET Requests
	public List<String> hello() {
		return List.of("Hello World!");
	}

}
