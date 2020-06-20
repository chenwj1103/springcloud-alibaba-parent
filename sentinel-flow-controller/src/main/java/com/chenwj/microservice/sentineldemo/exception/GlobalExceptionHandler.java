package com.chenwj.microservice.sentineldemo.exception;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author :  chen weijie
 * @Date: 2020-06-20 17:48
 */
@Component
@ControllerAdvice(basePackages = "com.chenwj.microservice.sentineldemo.controller")// 只处理该包下的 Controller 定义的接口
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(value = BlockException.class) // 因为这里是示例，所以暂时使用 JSONObject，实际项目最终定义一个 CommonResult。
    public JSONObject blockingExceptionHandler(BlockException blockException) {
        return new JSONObject()
                .fluentPut("code", 1024)
                .fluentPut("msg", "请求被拦截，拦截类型为 " + blockException.getClass().getSimpleName());
    }


}
