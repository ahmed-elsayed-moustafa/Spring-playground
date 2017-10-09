package com.jartest.boot;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pareva.controller.MultipleDBController;

@RestController
@SpringBootApplication
@Configuration
@EnableAutoConfiguration 
@ComponentScan(basePackages = {"com.pareva.controller"})
public class JarTestApplication {
	
	@Autowired
	MultipleDBController controller;
	
	@RequestMapping(value = "/test")
	public Object getHello() {
		return controller.selectTableByQuery("select count(*) from mobileClubBillingPlans");
	}

	public static void main(String[] args) throws Exception {
		SpringApplication.run(JarTestApplication.class, args);
	}
	
	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
	    return hemf.getSessionFactory();
	}

}
