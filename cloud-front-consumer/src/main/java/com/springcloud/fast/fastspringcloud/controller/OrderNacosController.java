package com.springcloud.fast.fastspringcloud.controller;


import com.springcloud.fast.fastspringcloud.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderNacosController {
    @Resource
    private RestTemplate restTemplate;

    @Value("${service-url.nacos-api-service}")
    private String serverURL;

    @GetMapping(value = "/front/api/nacos/list")
    public CommonResult paymentInfo() {
        return restTemplate.getForObject(serverURL + "/admin/wxConfig/list" , CommonResult.class);
    }

}
