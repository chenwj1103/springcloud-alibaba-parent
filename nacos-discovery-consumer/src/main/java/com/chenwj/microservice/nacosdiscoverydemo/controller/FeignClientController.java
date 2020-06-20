package com.chenwj.microservice.nacosdiscoverydemo.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-19 14:19
 */
@RequestMapping("/feignClient")
@RestController
public class FeignClientController {

    @Resource
    Client client;

    @GetMapping("/test")
    public String test() {
        String result = client.hello("didi");
        return "Return : " + result;
    }


    @FeignClient("alibaba-nacos-discovery-provider")
    interface Client {

        @GetMapping("/hello")
        String hello(@RequestParam(name = "name") String name);
    }

}
