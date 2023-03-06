package com.mesbahi;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.mesbahi.entity.Product;
import com.mesbahi.repo.ProductRepo;

@SpringBootApplication
public class KeycloakApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepo productRepo) {
		return args->{
			productRepo.save(new Product(1,"pantalon",200));
			productRepo.save(new Product(2,"pantalon",200));
			productRepo.save(new Product(3,"pantalon",200));
			productRepo.findAll().forEach(p->{
				System.out.println(p.getName());
			});
		};
	}

}
