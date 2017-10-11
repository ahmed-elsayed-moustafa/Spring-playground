package com.pareva.boot;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration 
@ComponentScan(basePackages = {"com.pareva.controller"})
@EnableJpaRepositories("com.pareva.Dao")
public class ZaBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZaBootApplication.class, args);
	}
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	    return hemf.getSessionFactory();
	}

}
