package com.chenwj.microservice.nacosdiscoverydemo.controller;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author :  chen weijie
 * @Date: 2020-06-19 15:27
 */
@RestController
@RequestMapping("/detailClient")
public class DetailClientController {


    @Resource
    private DiscoveryClient discoveryClient;

    @Resource(name = "detailRestTemplate")
    private RestTemplate restTemplate;

    @Resource
    private LoadBalancerClient loadBalancerClient;


    @GetMapping("/hello")
    public String hello(String name) {
        // <1> 获得服务 `demo-provider` 的一个实例
        ServiceInstance instance;
        if (true) {
            // 获取服务 `alibaba-nacos-discovery-provider 对应的实例列表
            List<ServiceInstance> instances = discoveryClient.getInstances("alibaba-nacos-discovery-provider");
            // 选择第一个
            instance = instances.size() > 0 ? instances.get(0) : null;
        } else {
            instance = loadBalancerClient.choose("alibaba-nacos-discovery-provider");
        }
        // <2> 发起调用
        if (instance == null) {
            throw new IllegalStateException("获取不到实例");
        }
        String targetUrl = instance.getUri() + "/hello?name=" + name;
        String response = restTemplate.getForObject(targetUrl, String.class);
        // 返回结果
        return "consumer:" + response;
    }







}
