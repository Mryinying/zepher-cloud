package com.zepher.cloud.zuul.difinition;

import lombok.Data;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Author wang_zy
 * @Date 2019/7/26 10:07
 *
 * 路由断言
 */
@Data
public class GatewayPredicateDefinition {

    //断言对应的Name
    private String name;
    //配置的断言规则
    private Map<String, String> args = new LinkedHashMap<>();
}
