package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Sts0224Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts0224Application.class, args);
	}

}
