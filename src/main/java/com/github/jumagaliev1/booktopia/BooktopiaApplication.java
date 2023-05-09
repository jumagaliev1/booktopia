package com.github.jumagaliev1.booktopia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableSwagger2
public class BooktopiaApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooktopiaApplication.class, args);
	}

}
