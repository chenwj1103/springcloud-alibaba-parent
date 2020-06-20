package com.chenwj.microservice.sentinelfeignconsumer.feign;

import com.chenwj.microservice.sentinelfeignconsumer.fallback.ProviderFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author :  chen weijie
 * @Date: 2020-06-21 02:31
 */
@FeignClient(name = "sentinel-controller", url = "http://127.0.0.1:8090",
        fallbackFactory = ProviderFeignClientFallbackFactory.class)
public interface ProviderFeignClient {

    @GetMapping("/demo/echo")
    String echo();
}
