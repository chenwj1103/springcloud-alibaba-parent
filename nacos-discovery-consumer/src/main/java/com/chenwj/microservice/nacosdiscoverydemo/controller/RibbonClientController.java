package com.chenwj.microservice.nacosdiscoverydemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author :  chen weijie
 * @Date: 2020-06-19 10:39
 */
@RestController
@RequestMapping("/ribbon")
@Slf4j
public class RibbonClientController {

    @Resource
    LoadBalancerClient loadBalancerClient;

    @GetMapping("/test")
    public String test(@RequestParam("name") String name) {
        // 通过spring cloud 中的负载均衡接口选取服务提供节点实现接口调用
        ServiceInstance serviceInstance = loadBalancerClient.choose("alibaba-nacos-discovery-provider");
        String url = serviceInstance.getUri() + "/hello?name=" + name;
        RestTemplate restTemplate = new RestTemplate();
        String result = restTemplate.getForObject(url, String.class);
        return "Invoke : " + url + ", return : " + result;
    }

}
