package com.chenwj.microservice.nacosdiscoverydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class NacosDiscoveryDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(NacosDiscoveryDemoApplication.class, args);
	}

}
