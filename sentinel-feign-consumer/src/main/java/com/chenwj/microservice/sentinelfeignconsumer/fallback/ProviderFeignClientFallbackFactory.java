package com.chenwj.microservice.sentinelfeignconsumer.fallback;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author :  chen weijie
 * @Date: 2020-06-21 02:32
 */
@Component
public class ProviderFeignClientFallbackFactory implements FallbackFactory<ProviderFeignClientFallback> {

    @Override
    public ProviderFeignClientFallback create(Throwable throwable) {
        // 可以给 DemoProviderFeignClientFallback 提供具体的 throwable 异常
        return new ProviderFeignClientFallback(throwable);
    }
}
