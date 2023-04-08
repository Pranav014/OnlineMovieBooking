package com.neu.edu.moviebookingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class MoviebookingsystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviebookingsystemApplication.class, args);
	}

}
