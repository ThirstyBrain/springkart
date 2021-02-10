package com.thirstybrain.springkart.productcatalogservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories(basePackages = "com.thirstybrain.springkart.productcatalogservice.infrastructure")
@SpringBootApplication
public class ProductCatalogServiceApplication {
	private static final Logger LOGGER = LoggerFactory.getLogger((ProductCatalogServiceApplication.class));
	public static void main(String[] args) {
        LOGGER.info("Application Start");
		SpringApplication.run(ProductCatalogServiceApplication.class, args);
	}
}
