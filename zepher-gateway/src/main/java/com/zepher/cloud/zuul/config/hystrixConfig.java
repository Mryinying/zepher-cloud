package com.zepher.cloud.zuul.config;

import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.context.annotation.Configuration;

/**
 * @Author wang_zy
 * @Date 2019/7/24 14:04
 */
@Configuration
public class hystrixConfig {

    public void hystrixProperty(){
        HystrixCommandProperties.Setter()
                .withExecutionTimeoutInMilliseconds(3000);
    }
}
