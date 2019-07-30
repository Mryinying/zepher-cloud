package com.zepher.cloud.feign.service;

import org.springframework.stereotype.Component;

/**
 * @Author wang_zy
 * @Date 2019/7/16 10:08
 * hystrix服务降级处理，防止因超时、异常等导致的服务调用雪崩
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry "+name;
    }

}
