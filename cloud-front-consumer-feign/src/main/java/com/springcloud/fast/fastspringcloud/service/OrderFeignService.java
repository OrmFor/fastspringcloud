package com.springcloud.fast.fastspringcloud.service;


import com.springcloud.fast.fastspringcloud.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient(name = "cloud-business-service")//服务名
public interface OrderFeignService {

    @GetMapping(value = "/admin/wxConfig/list")
    public CommonResult list();
}
