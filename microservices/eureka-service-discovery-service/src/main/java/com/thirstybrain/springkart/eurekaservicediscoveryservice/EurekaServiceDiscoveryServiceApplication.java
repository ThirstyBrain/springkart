package com.thirstybrain.springkart.eurekaservicediscoveryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableEurekaServer
@EnableZuulProxy
@SpringBootApplication
public class EurekaServiceDiscoveryServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EurekaServiceDiscoveryServiceApplication.class, args);
	}
}
