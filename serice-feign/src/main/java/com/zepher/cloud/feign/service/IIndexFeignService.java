package com.zepher.cloud.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author wang_zy
 * @Date 2019/7/22 14:35
 */
//指定了url就会访问该url地址，否则会把name参数当作服务名到注册中心中查询该名字服务，此时指定了url后可以随意命名
@FeignClient(name = "search-github" , url = "https://api.github.com")
public interface IIndexFeignService {

    @RequestMapping(value = "/search/repositories" , method = RequestMethod.GET)
    String search(@RequestParam("q") String query);

}