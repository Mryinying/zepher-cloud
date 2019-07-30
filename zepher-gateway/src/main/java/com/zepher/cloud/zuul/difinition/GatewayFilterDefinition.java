package com.zepher.cloud.zuul.difinition;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author wang_zy
 * @Date 2019/7/26 10:07
 *
 * 创建过滤器模型
 */
@Data
public class GatewayFilterDefinition {

    /* Filter Name */
    private String name;

    //对应的路由规则
    private Map<String, String> args = new LinkedHashMap<>();

}
