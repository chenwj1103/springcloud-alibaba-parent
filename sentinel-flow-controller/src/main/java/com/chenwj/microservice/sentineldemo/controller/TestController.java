package com.chenwj.microservice.sentineldemo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
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

    /**
     * 配置熔断规则
     *
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/sleep")
    public String sleep() throws InterruptedException {
        Thread.sleep(100L);
        return "sleep";
    }

    /**
     * 配置热资源限流规则
     * <p>
     * 为什么不直接使用 sentinel-spring-webmvc-adapter 库，自动给该 demo/product_info 接口生成的 /demo/product_info 资源呢？
     * <p>
     * 原因：因为 sentinel-spring-webmvc-adapter 库提供的 SentinelWebInterceptor 拦截器在调用 Sentinel 客户端时，并未传入参数，所以无法进行热点参数限流
     * 解决：使用 Sentinel 提供的 @SentinelResource 注解，自定义了 demo_product_info_hot 资源。然后，通过 Spring AOP 拦截该方法的调用，实现 Sentinel 的处理逻辑。
     * 在本小节中，就是为了热点参数限流
     *
     * @param id
     * @return
     */
    @GetMapping("/product_info")
    @SentinelResource("demo_product_info_hot")
    public String productInfo(Integer id) {
        return "商品编号：" + id;
    }




}
