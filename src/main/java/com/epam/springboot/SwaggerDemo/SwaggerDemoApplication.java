package com.epam.springboot.SwaggerDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SwaggerDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerDemoApplication.class, args);
	}

	/*@GetMapping("/message")
	public String message(){
		return "Welcome to Spring Boot with Swagger Demo";
	}*/

}
