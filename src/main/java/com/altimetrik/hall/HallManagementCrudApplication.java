package com.altimetrik.hall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = "com.altimetrik.hall.model")
@ComponentScan(basePackages = "com.altimetrik.hall")
//@EnableJpaRepositories(basePackages = "com.altimetrik.hall.repository")
public class HallManagementCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(HallManagementCrudApplication.class, args);
	}

}
