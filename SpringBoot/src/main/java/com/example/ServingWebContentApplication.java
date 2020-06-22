package com.example;

import com.example.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

/**
 * @author Hugo Malglaive
 * @version 1.0
 * @since SpringBoot
 */
@SpringBootApplication
public class ServingWebContentApplication {
	private static final Logger log = LoggerFactory.getLogger(ServingWebContentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServingWebContentApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(CustomerRepository repository, UserInterface userInter, AdressePostaleInterface adpoint) {
		return (args) -> {

			Customer customer1 = new Customer("JP", "Smith");
			repository.save(customer1);
			Customer custo2 = new Customer("Jesus", "Christ");
			repository.save(custo2);
			repository.save(new Customer("Arnold", "Schwarzi"));

		};
	}
}
