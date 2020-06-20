package com.chenwj.microservice.sentineldemo.util;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author :  chen weijie
 * @Date: 2020-06-21 00:53
 */
@Component
public class CustomRequestOriginParser implements RequestOriginParser {

    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        // <X> 从 Header 中，获得请求来源
        String origin = httpServletRequest.getHeader("s-user");
        // <Y> 如果为空，给一个默认的
        if (StringUtils.isEmpty(origin)) {
            origin = "default";
        }
        return origin;
    }

}
