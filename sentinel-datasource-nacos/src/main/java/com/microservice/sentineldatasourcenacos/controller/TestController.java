package com.microservice.sentineldatasourcenacos.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BlockException 有5个子类，包括 FlowException（流量控制）；
 * 包括 AuthorityException（黑名单控制）；
 * 包括 ParamFlowException（热点参数限流）；
 * 包括 SystemBlockException（系统自适应限流）；
 * 包括 DegradeException（熔断降级）；
 *
 * @author :  chen weijie
 * @Date: 2020-06-20 17:39
 */
@RestController
@RequestMapping("/demo")
public class TestController {


    @GetMapping("/echo")
    public String echo() {
        return "echo";
    }

    /**
     * 配置限流规则
     *
     * @return
     */
    @GetMapping("/test")
    public String test() {
        return "test";
    }


}
