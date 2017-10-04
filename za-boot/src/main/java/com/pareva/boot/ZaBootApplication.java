package com.pareva.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration 
@ComponentScan(basePackages = {"com.pareva.controller", "com.pareva.service"
})
@EntityScan(basePackages= {"com.pareva.model"})
@EnableJpaRepositories("com.pareva.Dao")
public class ZaBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaBootApplication.class, args);
	}
}
