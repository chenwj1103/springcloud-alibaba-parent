package com.chenwj.microservice.nacosdiscoverydemo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-19 11:45
 */
@RestController
@RequestMapping("/restTemplate")
public class RestTemplateClientController {

    @Resource(name = "restTemplate")
    RestTemplate restTemplate;

    @GetMapping("/test")
    public String test() {
        String result = restTemplate.getForObject("http://alibaba-nacos-discovery-provider/hello?name=didi", String.class);
        return "Return : " + result;
    }

}
