package com.chenwj.microservice.sentineldemo.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author :  chen weijie
 * @Date: 2020-06-21 01:12
 */
@RestController
public class ApiDemoController {


    @GetMapping("/entry_demo")
    public String entyDemoMethod() {

        Entry entry = null;

        try {
            entry = SphU.entry("entry_demo");
            return "执行成功";
        } catch (BlockException e) {
            e.printStackTrace();
            return "被拒绝";
        } finally {
            if (entry != null) {
                entry.exit();
            }
        }
    }

    @GetMapping("/annotations_demo")
    @SentinelResource(value = "annotations_demo", blockHandler = "blockHandler", fallback = "fallback")
    public String annotationsDemo(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("id 参数不允许为空！");
        }

        return "success";
    }

    /**
     * BlockHandler 处理函数，参数最后多一个 BlockException，其余与原函数一致.
     *
     * @param id
     * @param ex
     * @return
     */
    public String blockHandler(Integer id, BlockException ex) {
        return "block：" + ex.getClass().getSimpleName();
    }

    /**
     * Fallback 处理函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
     * <p>
     * fallback 和 blockHandler 的差异点，在于 blockHandler 只能处理 BlockException 异常，fallback 能够处理所有异常。
     *
     * @param id
     * @param throwable
     * @return
     */
    public String fallback(Integer id, Throwable throwable) {
        return "fallback：" + throwable.getMessage();
    }


}
