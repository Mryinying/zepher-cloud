package com.zepher.cloud.zuul.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * @Author wang_zy
 * @Date 2019/7/24 17:49
 */
@Configuration
public class RateLimiterConfig implements InitializingBean {

    /**
     * 路由限流配置  指定限流key  ip限流
     * @return
     */
    @Bean(value = "remoteAddrKeyResolver")
    public KeyResolver remoteAddrKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getAddress().getHostAddress());
    }

    /**
     * 路由限流配置  指定限流key  用户限流
     * @return
     */
    @Bean(value = "userKeyResolver")
    public KeyResolver userKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("userId"));
    }

    /**
     * 路由限流配置  指定限流key  接口限流
     * @return
     */
    @Bean(value = "apiKeyResolver")
    public KeyResolver apiKeyResolver() {
        return exchange -> Mono.just(exchange.getRequest().getPath().value());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("success");
    }
}
