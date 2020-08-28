package com.springcloud.fast.fastspringcloud.controller;


import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.springcloud.fast.fastspringcloud.CommonResult;
import com.springcloud.fast.fastspringcloud.fallback.CustomerBlockHandler;
import com.springcloud.fast.fastspringcloud.fallback.CustomerFallback;
import com.springcloud.fast.fastspringcloud.service.OrderFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private OrderFeignService orderFeignService;

    @GetMapping(value = "/feign/list")
    public CommonResult list(){
        return orderFeignService.list();
    }

    @GetMapping("/rateLimit")
    @SentinelResource(value = "rateLimit",
            fallback = "fallBack",
            fallbackClass = CustomerFallback.class,
            blockHandlerClass = CustomerBlockHandler.class,
            blockHandler = "handlerException")
    public CommonResult rateLimit() {
        Long time = System.nanoTime();
        CommonResult list = orderFeignService.list();
        Long time2 = System.nanoTime();
        //int i = 10/0;
        return list;
    }
}
