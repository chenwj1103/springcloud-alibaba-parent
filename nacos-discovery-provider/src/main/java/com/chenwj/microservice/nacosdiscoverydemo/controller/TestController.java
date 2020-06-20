package com.chenwj.microservice.nacosdiscoverydemo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  chen weijie
 * @Date: 2020-06-19 10:39
 */
@RestController
@Slf4j
public class TestController {


    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        log.info("invoked name = " + name);
        return "hello " + name;
    }

}
