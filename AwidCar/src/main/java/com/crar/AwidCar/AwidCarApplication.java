package com.crar.AwidCar;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.crar.AwidCar.exception"})
public class AwidCarApplication {

	public static void main(String[] args) {
		SpringApplication.run(AwidCarApplication.class, args);
	}

}
