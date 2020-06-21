package com.example;

import com.example.model.Customer;
import com.example.model.CustomerRepository;
import com.example.model.User;
import com.example.model.UserInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
	public CommandLineRunner demo(CustomerRepository repository, UserInterface userInter) {
		return (args) -> {
			// save a few customers
			/*repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			System.out.println("Customers found with findAll():");
			System.out.println("-------------------------------");
			for (Customer customer : repository.findAll()) {
				System.out.println(customer.toString());
			}
			System.out.println("");

			// fetch an individual customer by ID
			Customer customer = repository.findById(1L);
			System.out.println("Customer found with findById(1L):");
			System.out.println("--------------------------------");
			System.out.println(customer.toString());
			System.out.println("");

			// fetch customers by last name
			System.out.println("Customer found with findByLastName('Bauer'):");
			System.out.println("--------------------------------------------");
			repository.findByLastName("Bauer").forEach(bauer -> {
				System.out.println(bauer.toString());
			});
			// for (Customer bauer : repository.findByLastName("Bauer")) {
			//  log.info(bauer.toString());
			// }
			System.out.println("");*/
		};
	}
}
