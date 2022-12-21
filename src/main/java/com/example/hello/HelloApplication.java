package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.Base64;

@SpringBootApplication
@EnableAsync
public class HelloApplication {

	public static void main(String[] args) {

		SpringApplication.run(HelloApplication.class, args);
		// System.out.println(Base64.getEncoder().encodeToString("steve@gmail.com".getBytes()));
	}

}
