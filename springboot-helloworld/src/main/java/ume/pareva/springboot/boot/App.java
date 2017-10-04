package ume.pareva.springboot.boot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ume.pareva.springboot.service.BillingNotificationService;
import ume.pareva.springboot.service.SubscriptionNotificationService;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@RestController
@ComponentScan(basePackages = {"ume.pareva.springboot.controller", "ume.pareva.springboot.service"
})
@EntityScan(basePackages= {"ume.pareva.springboot.models"})
@EnableJpaRepositories(basePackages= {"ume.pareva.springboot.Dao"})
public class App {

	private static final Logger logger = LoggerFactory.getLogger(App.class);

	@Autowired
	private BillingNotificationService bs;
	
	@Autowired
	private SubscriptionNotificationService ss;

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
		return new HibernateJpaSessionFactoryBean();
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class);
	}

	@GetMapping("/billing")
	public String sayHello() {
		return bs.findAll()+"";
	}
	
	@GetMapping("/subscription")
	public String sayBye() {
		return ss.findAll()+"";
	}
}
