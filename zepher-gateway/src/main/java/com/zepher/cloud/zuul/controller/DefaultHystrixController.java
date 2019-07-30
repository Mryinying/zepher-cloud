package com.zepher.cloud.zuul.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author wang_zy
 * @Date 2019/7/24 9:34
 */
@Slf4j
@RestController
public class DefaultHystrixController {

    @RequestMapping("/defaultfallback")
    public Map<String , Object> defaultfallback(){
        log.info("默认降级处理");
        Map<String ,Object> map = new HashMap<>();
        map.put("code","503");
        map.put("msg","服务异常，降级");
        return map;
    }
}
