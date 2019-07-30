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
@FeignClient(name = "search-12306" , url = "https://kyfw.12306.cn")
public interface IIndex12306Service {

    @RequestMapping(value = "/otn/leftTicket/query" , method = RequestMethod.GET)
    String search(@RequestParam("leftTicketDTO.train_date") String train_date,
                  @RequestParam("leftTicketDTO.from_station") String from_station,
                  @RequestParam("leftTicketDTO.to_station") String to_station,
                  @RequestParam("purpose_codes") String purpose_codes);

}