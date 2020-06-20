package com.chenwj.microservice.sentinelfeignconsumer.controller;

import com.chenwj.microservice.sentinelfeignconsumer.feign.ProviderFeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-21 02:28
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private ProviderFeignClient providerFeignClient;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/echo")
    public String echo() {
        return providerFeignClient.echo();
    }


    @GetMapping("/echo2")
    public String echo2() {
        return restTemplate.getForObject("http://127.0.0.1:8090/demo/echo", String.class);
    }
}
