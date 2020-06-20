package com.chenwj.microservice.sentinelfeignconsumer.fallback;

import com.chenwj.microservice.sentinelfeignconsumer.feign.ProviderFeignClient;

/**
 * @author :  chen weijie
 * @Date: 2020-06-21 02:32
 */
public class ProviderFeignClientFallback implements ProviderFeignClient {

    private Throwable throwable;

    public ProviderFeignClientFallback(Throwable throwable) {
        this.throwable = throwable;
    }

    @Override
    public String echo() {
        return "fallback:" + throwable.getClass().getSimpleName();
    }
}
