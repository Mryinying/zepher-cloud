package com.zepher.cloud.feign.web;

import com.zepher.cloud.feign.service.IIndex12306Service;
import com.zepher.cloud.feign.service.IIndexFeignService;
import com.zepher.cloud.feign.service.SchedualServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author wang_zy
 * @Date 2019/7/16 9:49
 */
@RestController
public class HiController {


    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired private IIndexFeignService feignService;

    @Autowired private IIndex12306Service index12306Service;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name) {
        String s = schedualServiceHi.sayHiFromClientOne(name) + "=========from feign";
        return s;
    }

    @GetMapping(value = "/query")
    public String query(@RequestParam String query) {
        String s = feignService.search(query) + "=========from feign";
        return s;
    }

    @GetMapping(value = "/search")
    public String query(@RequestParam("leftTicketDTO.train_date") String train_date,
                        @RequestParam("leftTicketDTO.from_station") String from_station,
                        @RequestParam("leftTicketDTO.to_station") String to_station,
                        @RequestParam("purpose_codes") String purpose_codes) {
        String s = index12306Service.search(train_date,from_station,to_station,purpose_codes);
        return s;
    }
}

