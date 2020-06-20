package com.chenwj.microservice.sentineldemo.rule;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

/**
 * 初始化规则，可以参考 https://github.com/alibaba/Sentinel/wiki/%E5%A6%82%E4%BD%95%E4%BD%BF%E7%94%A8#%E5%AE%9A%E4%B9%89%E8%B5%84%E6%BA%90
 * @author :  chen weijie
 * @Date: 2020-06-21 01:20
 */
//@Component
public class InitRule implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule("entry_demo");
        // set limit qps to 20
        rule.setCount(20);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }
}
