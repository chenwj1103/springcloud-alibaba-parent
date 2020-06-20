package com.chenwj.microservice.nacosconfigmutilprofile;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class NacosConfigMutilProfileApplication {


    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(NacosConfigMutilProfileApplication.class, args);
        String userName = applicationContext.getEnvironment().getProperty("nacos.name");
        System.err.println("==" + userName);
    }

}
