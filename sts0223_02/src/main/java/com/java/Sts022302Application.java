package com.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class Sts022302Application {

	public static void main(String[] args) {
		SpringApplication.run(Sts022302Application.class, args);
	}

}
