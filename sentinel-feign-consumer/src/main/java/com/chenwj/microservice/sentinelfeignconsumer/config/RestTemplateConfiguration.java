package com.chenwj.microservice.sentinelfeignconsumer.config;

import com.alibaba.cloud.sentinel.annotation.SentinelRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author :  chen weijie
 * @Date: 2020-06-21 02:44
 */
@Configuration
public class RestTemplateConfiguration {


    /**
     * 通过 @SentinelRestTemplate 注解，声明 Sentinel 对 RestTemplate 的支持。
     *
     * @return
     */
    @Bean
    @SentinelRestTemplate
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
