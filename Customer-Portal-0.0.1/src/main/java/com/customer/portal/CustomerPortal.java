package com.customer.portal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(scanBasePackages = { "com" })
@EntityScan(basePackages = { "com" })
@ComponentScan(basePackages = { "com" })
@EnableJpaRepositories(basePackages = { "com" })
@EnableAsync
public class CustomerPortal {
	 Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	 
	 private void start()
	 {
		 logger.info("Service Started at port 8080");
	 }
	public static void main(String[] args) {
		SpringApplication.run(CustomerPortal.class, args);
		new CustomerPortal().start();
	}

}
