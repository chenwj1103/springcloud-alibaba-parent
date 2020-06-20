package com.chenwj.microservice.nacosdiscoverydemo.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author :  chen weijie
 * @Date: 2020-06-19 11:34
 */
@Configuration
public class RestTemplateBean {

    @Bean(name = "restTemplate")
    @LoadBalanced
    public RestTemplate instance() {
        return new RestTemplate();
    }


    @Bean(name= "detailRestTemplate")
    public RestTemplate getInstance() {
        return new RestTemplate();
    }
}

